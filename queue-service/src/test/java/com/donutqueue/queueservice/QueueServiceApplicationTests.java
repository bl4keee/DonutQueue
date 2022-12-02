package com.donutqueue.queueservice;

import com.donutqueue.api.queue.domain.OrderDTO;
import com.donutqueue.api.queue.domain.OrderExtendedDTO;
import com.donutqueue.queueservice.customer.application.port.in.AddOrderCommand;
import com.donutqueue.queueservice.customer.application.port.out.AddOrderPort;
import com.donutqueue.queueservice.customer.application.port.out.CancelOrderPort;
import com.donutqueue.queueservice.customer.application.port.out.CheckOrderPort;
import com.donutqueue.queueservice.employee.application.port.in.GetNextDeliveryPort;
import com.donutqueue.queueservice.management.application.port.out.GetOrdersPort;
import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class QueueServiceApplicationTests {

	private static final int TEST_CLIENT_ID = 1;
	private static final int TEST_ORDER_QUANTITY = 1;
	private static final int TEST_QUEUE_POSITION = 1;
	private static final double TEST_APPROX_WAIT_TIME = 1;

	@Autowired
	private WebTestClient client;

	@MockBean
	private AddOrderPort addOrderPort;

	@MockBean
	private CancelOrderPort cancelOrderPort;

	@MockBean
	private CheckOrderPort checkOrderPort;

	@MockBean
	private GetNextDeliveryPort getNextDeliveryPort;

	@MockBean
	private GetOrdersPort getOrdersPort;


	@BeforeEach
	void setUp() {

		when(addOrderPort.addOrderToQueue(any(AddOrderCommand.class)))
				.thenReturn(getOrder(TEST_CLIENT_ID, TEST_ORDER_QUANTITY));

		when(checkOrderPort.checkOrder(TEST_CLIENT_ID))
				.thenReturn(getExtendedOrder(TEST_CLIENT_ID, TEST_QUEUE_POSITION, TEST_ORDER_QUANTITY, TEST_APPROX_WAIT_TIME));

		when(getOrdersPort.getAllOrdersInQueue())
				.thenReturn(singletonList(getExtendedOrder(TEST_CLIENT_ID, TEST_QUEUE_POSITION, TEST_ORDER_QUANTITY, TEST_APPROX_WAIT_TIME)));

		when(getNextDeliveryPort.getNextDelivery())
				.thenReturn(singletonList(getOrder(TEST_CLIENT_ID, TEST_ORDER_QUANTITY)));
	}

	@Test
	@DisplayName("1. Client test - adding an order")
	void shouldAddOrder() {

		client.post()
				.uri("/order?clientId=" + TEST_CLIENT_ID + "&quantity=" + TEST_ORDER_QUANTITY)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.clientId").isEqualTo(TEST_CLIENT_ID)
				.jsonPath("$.quantityOfDonuts").isEqualTo(TEST_ORDER_QUANTITY);
	}

	@Test
	@DisplayName("2. Client test - checking an order")
	void shouldCheckOrder() {

		client.get()
				.uri("/order/" + TEST_CLIENT_ID)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.clientId").isEqualTo(TEST_CLIENT_ID)
				.jsonPath("$.quantityOfDonuts").isEqualTo(TEST_ORDER_QUANTITY)
				.jsonPath("$.queuePosition").isEqualTo(TEST_QUEUE_POSITION)
				.jsonPath("$.approximateWaitTime").isEqualTo(TEST_APPROX_WAIT_TIME);
	}

	@Test
	@DisplayName("3. Manager test - getting the list of all orders")
	void shouldGetAllOrders() {

		client.get()
				.uri("/orders")
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.length()").isEqualTo(1);
	}

	@Test
	@DisplayName("4. Employee test - getting the next delivery")
	void shouldGetNextDelivery() {

		client.get()
				.uri("/delivery")
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.length()").isEqualTo(1);
	}

	@Test
	@DisplayName("5. Client test - canceling an order")
	void shouldCancelOrder() {

		client.delete()
				.uri("/order/" + TEST_CLIENT_ID)
				.accept(APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk();
	}

	private OrderDTO getOrder(int clientId, int quantityOfDonuts) {
		return  new OrderDTO(clientId, quantityOfDonuts);
	}

	private OrderExtendedDTO getExtendedOrder(int clientId, int queuePosition , int quantityOfDonuts, double approxWaitTime) {
		return new OrderExtendedDTO(clientId, queuePosition, quantityOfDonuts, approxWaitTime);
	}

}

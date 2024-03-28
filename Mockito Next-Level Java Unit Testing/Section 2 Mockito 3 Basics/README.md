
## Section 02 Mockito 3 Basics

Mockito 3 Basics

# What I Learned


# First Mocks

- First mock test example below.

```
package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

class Test01FirstMocks {

	private BookingService bookingService; // Main Service to test dont mock

	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {

		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

	}

	@Test
	void  should_CalculateCorrectPrize_When_CorrectInput() {
		
		// Given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05), 2, false);		
		double expected = 4 * 2 * 50.0;
		
		
		// When
		double actual = bookingService.calculatePrice(bookingRequest);
		
		//Then
		assertEquals(expected, actual);
		
	}

}

```

- Following will return **mock** to user `this.paymentServiceMock = mock(PaymentService.class);`

# Default Return Values

- If you don't specify any return values, there different default values. See below.

<img src="mockingDefaultValues.PNG" alt="alt text" width="400"/>

- By default Mockito uses **nice mocks**.
	- Returning values makes sense.
	- Nice mocks **default values:**
		- Empty list
		- Null Object
		- 0 / false primitives
- We can specify return type for specific input or any all input

- Test from this chapter below.

```
package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

class Test02DefaultRetrunValues {

	private BookingService bookingService; // Main Service to test dont mock

	private PaymentService paymentServiceMock;
	private RoomService roomServiceMock;
	private BookingDAO bookingDAOMock;
	private MailSender mailSenderMock;

	@BeforeEach
	void setup() {

		this.paymentServiceMock = mock(PaymentService.class);
		this.roomServiceMock = mock(RoomService.class);
		this.bookingDAOMock = mock(BookingDAO.class);
		this.mailSenderMock = mock(MailSender.class);

		this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

		
		System.out.println("List returned " + roomServiceMock.getAvailableRooms());
		System.out.println("Object returned " + roomServiceMock.findAvailableRoomId(null));
		System.out.println("Primitive returned "+ roomServiceMock.getRoomCount());
	}
	
	@Test
	void should_CountAvailablePlaces()
	{
		//given
		int expected = 0;
		
		//when
		int actual = bookingService.getAvailablePlaceCount();
			
		//then
		assertEquals(expected, actual);
	}


}

```

# Returning Custom Values

- **When()** something happens then → do something
	- Chaining when then
		- This changes default behavior from empty list to single element list
		- Now when `getAvailableRooms()` is called return list with new Room 

```
when(this.roomServiceMock.getAvailableRooms()).thenReturn(Collections.singletonList(new Room("Room 1", 2)));
```
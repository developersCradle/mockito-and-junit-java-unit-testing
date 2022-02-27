package com.mockitotutorial.happyhotel.booking;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;


import java.time.LocalDate;

class Test09MockingVoidMethods {

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
	void  should_ThrowException_When_MailNotReady() {
		
		//Given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05), 2, false);		
		when(this.roomServiceMock.findAvailableRoomId(bookingRequest))
		.thenThrow(BusinessException.class);
//		Does not work
//		when(this.mailSenderMock.sendBookingConfirmation(any())).thenThrow(BusinessException.class);
		doThrow(new BusinessException()).when(mailSenderMock).sendBookingConfirmation(any());
		
		
		//When
		Executable executable = () -> bookingService.makeBooking(bookingRequest);
		
		//Then
		assertThrows(BusinessException.class, executable);
	}

	
	@Test
	void  should_NotThrowException_When_MailNotReady() {
		
		//Given
		BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05), 2, false);		
//		Does not work
//		when(this.mailSenderMock.sendBookingConfirmation(any())).thenThrow(BusinessException.class);
		doNothing().when(mailSenderMock).sendBookingConfirmation(any());
		
		
		//When
		bookingService.makeBooking(bookingRequest);
		
		//Then
		// no exception thrown
	}

}

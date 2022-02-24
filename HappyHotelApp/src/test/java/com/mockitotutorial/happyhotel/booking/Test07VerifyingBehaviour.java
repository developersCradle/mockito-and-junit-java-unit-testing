package com.mockitotutorial.happyhotel.booking;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Test07VerifyingBehaviour {

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

    this.bookingService =
        new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);

  }

  @Test
  void should_InvokePayment_When_Prepaid() {

    // Given
    BookingRequest bookingRequest =
        new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05), 2, true);

    // When

    bookingService.makeBooking(bookingRequest);
    // Then
    verify(paymentServiceMock, times(1)).pay(bookingRequest, 400.0);
    verifyNoMoreInteractions(paymentServiceMock); // Check if paymentServiceMock was called once

  }


  @Test
  void should_NotInvokePayment_WhenNotPrepaid() {

    // Given
    BookingRequest bookingRequest =
        new BookingRequest("1", LocalDate.of(2020, 01, 01), LocalDate.of(2020, 01, 05), 2, false);


    // When

    bookingService.makeBooking(bookingRequest);

    // Then
    verify(paymentServiceMock, never()).pay(any(), anyDouble());
  }
}

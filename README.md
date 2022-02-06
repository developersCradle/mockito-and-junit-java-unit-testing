## Mockito: Next-Level Java Unit Testing

![Mockito](pic.jpg)

All course material from Mockito: Next-Level Java Unit Testing by Adrian Więch

Every section contains my own notes

[The Course at Udemy](https://www.udemy.com/course/mockito3/)   

Insert certificate here when completed

## Progress/Curriculum


- [x] Section 01 - Section 1: First things first
- [ ] Section 02 - Section 2: Mockito 3 Basics
- [ ] Section 03 - Section 3: More Advanced Concepts
- [ ] Section 04 - Section 4: Additional Videos
- [ ] Section 05 - Section 5: Want to Learn More?



# What I Learned 1

- <img src="NeedForMockito.PNG" alt="alt text" width="300"/>

- This could fail if website is unavailable
	- We can solve this using mocks
- <img src="mock.PNG" alt="alt text" width="300"/>
- Junit does not proviode mocking ability :(
	- In Java world, most popilarars are JMockit, EASYMOCK and Mockito
		- Mockito by far the most popular at the writing time
- Mockito needs at least Java 8 version
- <img src="class_diagram.png" alt="alt text" width="300"/>
	- Don't mock methods from BookService
		- Test all mehthods from BookService
- ``new BookingService(paymentService, roomService, bookingDAO, mailSender)``
	- We want to mock out dependencies form this service
		- Basic way to do this is using mock``this.paymentService = mock(PaymentService.class);``
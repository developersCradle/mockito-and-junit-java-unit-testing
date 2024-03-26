
## Section 01 Introduction

Introduction

# What I Learned

# Introduction

<img src="weAreGoingToUse.JPG" alt="alt text" width="400"/>

# Mocking Theory

<img src="unitTests.JPG" alt="alt text" width="400"/>

1. We usually test single units. 

<img src="test.JPG" alt="alt text" width="400"/>

1. Class to test.
2. Unit test for this class.

<img src="goodJava.JPG" alt="alt text" width="400"/>

- Good OOP java, should have single responsibility.

<img src="exampleGoodJava.JPG" alt="alt text" width="400"/>

1. We want to create class for horoscope service class.

- With following behavior defined in **1.**

<img src="horoscopeServiceClass.JPG" alt="alt text" width="400"/>

1. Dependencies

- Ideas is to write unit test for service only, but there is two dependencies.

<img src="NeedForMockito.PNG" alt="alt text" width="400"/>

1. Unit test which was suppose to test **service** class.
    - Under hood it will connect to db and look thought horoscope provider.

2.  This could fail if website is unavailable. Not because test itself is wrong, but the dependencies. This could be fine for **integration test**, but not for unit test.
	- We can solve this using **mocks** 

<img src="mock.PNG" alt="alt text" width="500"/>

- To fix this we use following. **Mocks**
    - We will mock
    - We will learn to test behavior of these mocks

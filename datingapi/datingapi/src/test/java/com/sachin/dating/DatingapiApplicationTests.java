package com.sachin.dating;

import com.sachin.dating.controllers.UserAccountController;
import com.sachin.dating.entities.Interest;
import com.sachin.dating.entities.UserAccount;
import com.sachin.dating.repos.InterestRepository;
import com.sachin.dating.repos.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class DatingapiApplicationTests {

	@Mock
	private UserAccountRepository userAccountRepository;

	@Mock
	private InterestRepository interestRepository;

	@InjectMocks
	private UserAccountController controller;


	@Test
	void testRegisterUser() {
		UserAccount userAccount= new UserAccount();
		UserAccount savedUserAccount = new UserAccount();
		savedUserAccount.setId(123);

		when(userAccountRepository.save(userAccount)).thenReturn(savedUserAccount);
		UserAccount ouputUserAccount = controller.registerUser(userAccount);

		Assertions.assertNotNull(ouputUserAccount);
		Assertions.assertNotNull(ouputUserAccount.getId());
		Assertions.assertEquals(123, ouputUserAccount.getId());

		verify(userAccountRepository).save(userAccount);

	}

	@Test
	public void testUpdateInterest()
	{
		Interest interest = new Interest();
		interest.setUserAccountId(123);
		when(userAccountRepository.findById(123)).thenReturn(
				Optional.of(new UserAccount()));
		Interest saveInterest = new Interest();
		when(interestRepository.save(interest)).thenReturn(saveInterest);
		Interest outputInterest = controller.updateInterest(interest);

		Assertions.assertNotNull(outputInterest);
		Assertions.assertNotNull(outputInterest.getId());
		Assertions.assertEquals(123,outputInterest.getId());

		verify(userAccountRepository).findById(123);
		verify(interestRepository).save(interest);


	}

}
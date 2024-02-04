package kr.megaptera.assignment.repository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CartRepositoryTest {
    @MockBean
    private CartRepository cartRepository;
}
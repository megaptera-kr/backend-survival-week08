package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.application.review.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetReviewDTOsService getReviewDTOsService;

    @MockBean
    private CreateReviewService createReviewService;

    @MockBean
    private UpdateReviewService updateReviewService;

    @MockBean
    private DeleteReviewService deleteReviewService;


    @Test
    @DisplayName("GET 리뷰 목록")
    void list() throws Exception {
        String productId = "BOTTOM_001";
        given(getReviewDTOsService.getReviewDTOs(productId)).willReturn(
                List.of(
                        new ReviewDTO("ID_001", productId, "jyh", "good"),
                        new ReviewDTO("ID_002", productId, "bjs", "nice")
                )
        );

        mockMvc.perform(get("/reviews?productId=" + productId))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("nice")));
    }

    @Test
    @DisplayName("POST 리뷰 생성")
    void createReview() throws Exception {
        String productId = "BOTTOM_001";
        String body = """
                {
                    "author": "jyh",
                    "content": "pi ka chu!!"
                }
                """;

        mockMvc.perform(post("/reviews?productId=" + productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("PATCH 리뷰 수정")
    void updateReview() throws Exception {
        String productId = "BOTTOM_001";
        String reviewId = "ID_001";
        String body = """
                {
                    "content": "changed content"
                }
                """;

        mockMvc.perform(patch("/reviews/" + reviewId + "?productId=" + productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isNoContent());

    }

    @Test
    @DisplayName("DELETE 리뷰 삭제")
    void deleteReview() throws Exception {
        String productId = "BOTTOM_001";
        String reviewId = "ID_001";

        mockMvc.perform(delete("/reviews/" + reviewId + "?productId=" + productId))
                .andExpect(status().isNoContent());
    }


}
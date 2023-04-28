package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.*;
import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;

import javax.print.attribute.standard.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebMvcTest(CartController.class)
public class LineItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetLineItemsService getLineItemsService;

    @MockBean
    private CreateLineItemService createLineItemService;

    @MockBean
    private UpdateLineItemsService updateLineItemsService;

    @Test
    void 카트불러오기() throws Exception {
        given(getLineItemsService.getLineItemDtos())
                .willReturn(List.of(new LineItemDto("001","Ipad",1L,20000L,20000L)));

        mockMvc.perform(get("/cart-line-items"))
                        .andExpect(status().isOk())
                .andExpect(content().json("{\"lineItems\":[{\"id\":\"001\",\"productName\":\"Ipad\",\"quantity\":1,\"totalPrice\":20000,\"unitPrice\":20000}]}"));
    }

    @Test
    void 카트에추가하기() throws Exception {
        String productId = "001";

        String json = """
                {
                    "productId" : "001",
                    "quantity" : 1
                }
                """;

        mockMvc.perform(post("/cart-line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());

        verify(createLineItemService).createlineItem(any(LineItemCreateDto.class));
    }

    @Test
    void 카트수량변경() throws Exception {
        String id = "001";

        String json = """
                {
                    "quantity": "2"
                }
                """;
        mockMvc.perform(patch("/cart-line-items/"+id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());

        verify(updateLineItemsService).updatelineItem(eq(id),any(LineItemUpdateDto.class));
    }
}
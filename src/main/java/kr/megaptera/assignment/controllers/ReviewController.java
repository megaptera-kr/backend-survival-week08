package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.application.review.*;
import kr.megaptera.assignment.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/reviews")
public class ReviewController {

    private final GetReviewDTOsService getReviewDTOsService;

    private final CreateReviewService createReviewService;

    private final UpdateReviewService updateReviewService;

    private final DeleteReviewService deleteReviewService;

    public ReviewController(GetReviewDTOsService getReviewDTOsService,
                            CreateReviewService createReviewService,
                            UpdateReviewService updateReviewService,
                            DeleteReviewService deleteReviewService) {
        this.getReviewDTOsService = getReviewDTOsService;
        this.createReviewService = createReviewService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
    }

    @GetMapping
    public List<ReviewDTO> list(
            @RequestParam String productId
    ) {
        List<ReviewDTO> reviewDTOs = getReviewDTOsService.getReviewDTOs(productId);

        return reviewDTOs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDTO create(
            @RequestParam String productId,
            @RequestBody ReviewCreateDTO reviewCreateDTO
    ) {
        ReviewDTO reviewDTO = createReviewService.create(productId, reviewCreateDTO);

        return reviewDTO;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable String id,
            @RequestParam String productId,
            @RequestBody ReviewUpdateDTO reviewUpdateDTO
    ) {
        updateReviewService.update(id, productId, reviewUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id,
            @RequestParam String productId
    ) {
        deleteReviewService.delete(id, productId);
    }

    @ExceptionHandler(ReviewNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String reviewNotFound() {
        return "review doesn't exist..";
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFound() {
        return "product doesn't exist..";
    }
}

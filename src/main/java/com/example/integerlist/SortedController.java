package com.example.integerlist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Sort")
public class SortedController {
    private final SortedService sortedService;

    public SortedController(SortedService sortedService) {
        this.sortedService = sortedService;
    }
    @GetMapping("/Bubble")
    public Long timeOfsortBubble() {
        return sortedService.timeOfsortBubble();
    }
    @GetMapping("/Selection")
    public Long timeOfsortSelection() {
        return sortedService.timeOfsortSelection();
    }
    @GetMapping("/Insertion")
    public Long timeOfsortInsertion() {
        return sortedService.timeOfsortInsertion();
    }
}

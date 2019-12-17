package com.sivak.computershop.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ControllerUtils {
    static Map<String, String> getErrorMap(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .collect(Collectors.toMap(fieldError -> fieldError.getField() + "Error", FieldError::getDefaultMessage));
    }

    static void addCheckedLaptopsToViewLayer(List<Integer> monitor, String manufacturer, String cpu,
                                             List<Integer> ram, List<String> storageType,
                                             List<Integer> storageSize, List<String> videoCard,
                                             double price1, double price2, Model model) {
        model.addAttribute("monitor", monitor);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("cpu", cpu);
        model.addAttribute("ram", ram);
        model.addAttribute("storageType", storageType);
        model.addAttribute("storageSize", storageSize);
        model.addAttribute("videoCard", videoCard);
        model.addAttribute("price1", price1);
        model.addAttribute("price2", price2);
    }

    static void addCheckedTabletsToViewLayer(List<String> os, List<Integer> monitor, String manufacturer, String cpu,
                                             List<Integer> ram, List<Boolean> flashCard, List<Integer> storageSize,
                                             double price1, double price2, Model model) {
        model.addAttribute("os", os);
        model.addAttribute("monitor", monitor);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("cpu", cpu);
        model.addAttribute("ram", ram);
        model.addAttribute("flashCard", flashCard);
        model.addAttribute("storageSize", storageSize);
        model.addAttribute("price1", price1);
        model.addAttribute("price2", price2);
    }

    static void addCheckedPhonesToViewLayer(List<Boolean> dualSim, String manufacturer, List<Integer> monitor,
                                     String cpu, List<Integer> ram, List<Integer> storageSize,
                                     List<Boolean> flashCard, double price1, double price2, Model model) {
        model.addAttribute("dualSim", dualSim);
        model.addAttribute("manufacturer", manufacturer);
        model.addAttribute("monitor", monitor);
        model.addAttribute("cpu", cpu);
        model.addAttribute("ram", ram);
        model.addAttribute("storageSize", storageSize);
        model.addAttribute("flashCard", flashCard);
        model.addAttribute("price1", price1);
        model.addAttribute("price2", price2);
    }
}

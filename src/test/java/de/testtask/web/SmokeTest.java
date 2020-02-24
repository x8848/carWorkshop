package de.testtask.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController userController;

    @Autowired
    private WorkShopController workShopController;

    @Autowired
    private AppointmentController appointmentController;

    @Test
    public void contexLoads() {
        assertThat(userController).isNotNull();
        assertThat(workShopController).isNotNull();
        assertThat(appointmentController).isNotNull();
    }
}
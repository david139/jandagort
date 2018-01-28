package com.jandagort.config;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class LocalDateTimeAttributeConverterTest {

    private LocalDateTimeAttributeConverter underTest;

    @Before
    public void setUp() {
        underTest = new LocalDateTimeAttributeConverter();
    }

    @Test
    public void convertToDatabaseColumn() {
        // Given
        LocalDateTime localDateTime = LocalDateTime.of(2000, 1, 2,3,4,5);
        Timestamp expected = Timestamp.valueOf("2000-1-2 03:04:05");

        // When
        Timestamp actual = underTest.convertToDatabaseColumn(localDateTime);

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void convertToEntityAttribute() {
        // Given
        Timestamp timestamp = Timestamp.valueOf("2000-1-2 03:04:05");
        LocalDateTime expected = LocalDateTime.of(2000, 1, 2,3,4,5);

        // When
        LocalDateTime actual = underTest.convertToEntityAttribute(timestamp);

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
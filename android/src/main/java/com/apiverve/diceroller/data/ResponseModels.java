// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     DiceRollerData data = Converter.fromJsonString(jsonString);

package com.apiverve.diceroller.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static DiceRollerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(DiceRollerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(DiceRollerData.class);
        writer = mapper.writerFor(DiceRollerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// DiceRollerData.java

package com.apiverve.diceroller.data;

import com.fasterxml.jackson.annotation.*;

public class DiceRollerData {
    private String diceNotation;
    private long numDice;
    private long numSides;
    private long modifier;
    private long[] rolls;
    private long total;
    private long totalWithModifier;
    private long minRoll;
    private long maxRoll;
    private double averageRoll;
    private long theoreticalMin;
    private long theoreticalMax;
    private double theoreticalAverage;
    private String expression;

    @JsonProperty("dice_notation")
    public String getDiceNotation() { return diceNotation; }
    @JsonProperty("dice_notation")
    public void setDiceNotation(String value) { this.diceNotation = value; }

    @JsonProperty("num_dice")
    public long getNumDice() { return numDice; }
    @JsonProperty("num_dice")
    public void setNumDice(long value) { this.numDice = value; }

    @JsonProperty("num_sides")
    public long getNumSides() { return numSides; }
    @JsonProperty("num_sides")
    public void setNumSides(long value) { this.numSides = value; }

    @JsonProperty("modifier")
    public long getModifier() { return modifier; }
    @JsonProperty("modifier")
    public void setModifier(long value) { this.modifier = value; }

    @JsonProperty("rolls")
    public long[] getRolls() { return rolls; }
    @JsonProperty("rolls")
    public void setRolls(long[] value) { this.rolls = value; }

    @JsonProperty("total")
    public long getTotal() { return total; }
    @JsonProperty("total")
    public void setTotal(long value) { this.total = value; }

    @JsonProperty("total_with_modifier")
    public long getTotalWithModifier() { return totalWithModifier; }
    @JsonProperty("total_with_modifier")
    public void setTotalWithModifier(long value) { this.totalWithModifier = value; }

    @JsonProperty("min_roll")
    public long getMinRoll() { return minRoll; }
    @JsonProperty("min_roll")
    public void setMinRoll(long value) { this.minRoll = value; }

    @JsonProperty("max_roll")
    public long getMaxRoll() { return maxRoll; }
    @JsonProperty("max_roll")
    public void setMaxRoll(long value) { this.maxRoll = value; }

    @JsonProperty("average_roll")
    public double getAverageRoll() { return averageRoll; }
    @JsonProperty("average_roll")
    public void setAverageRoll(double value) { this.averageRoll = value; }

    @JsonProperty("theoretical_min")
    public long getTheoreticalMin() { return theoreticalMin; }
    @JsonProperty("theoretical_min")
    public void setTheoreticalMin(long value) { this.theoreticalMin = value; }

    @JsonProperty("theoretical_max")
    public long getTheoreticalMax() { return theoreticalMax; }
    @JsonProperty("theoretical_max")
    public void setTheoreticalMax(long value) { this.theoreticalMax = value; }

    @JsonProperty("theoretical_average")
    public double getTheoreticalAverage() { return theoreticalAverage; }
    @JsonProperty("theoretical_average")
    public void setTheoreticalAverage(double value) { this.theoreticalAverage = value; }

    @JsonProperty("expression")
    public String getExpression() { return expression; }
    @JsonProperty("expression")
    public void setExpression(String value) { this.expression = value; }
}
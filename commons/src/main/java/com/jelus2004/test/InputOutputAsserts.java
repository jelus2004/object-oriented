package com.jelus2004.test;

import io.vavr.Tuple;
import io.vavr.Tuple2;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.fest.assertions.api.Assertions.assertThat;

public class InputOutputAsserts {

    public static <T> InputOutputAssert<T> assertInputOutput(final Function<Scanner, T> test) {
        return new InputOutputAssert<>(test);
    }

    public static <T> InputAssert<T> withInput(final Function<Scanner, T> test) {
        return new InputAssert<>(test);
    }

    public static OutputAssert<Void> assertOutput(final Runnable test) {
        return new OutputAssert<>(captureOutput(test));
    }

    public static <T> OutputAssert<T> assertOutput(final Supplier<T> test) {
        final Tuple2<T, String> result = captureOutput(test);
        return new OutputAssert<T>(result._2, result._1);
    }

    private static <T> Tuple2<T, String> captureOutput(Supplier<T> test) {
        try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(out));

            final T value = test.get();

            final ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray());
            final StringBuffer sb = new StringBuffer();
            byte[] bytes = new byte[is.available()];
            is.read(bytes, 0, is.available());
            final String result = new String(bytes);

            return Tuple.of(value, result);

        } catch (final IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String captureOutput(Runnable test) {
        return captureOutput(() -> {
            test.run();
            return null;
        })._2;
    }


    public static class OutputAssert<T> {
        private final String output;
        private final T result;

        OutputAssert(final String output, final T result) {
            this.output = output;
            this.result = result;
        }

        OutputAssert(final String output) {
            this(output, null);
        }

        public OutputAssert<T> hasOutput(String expected) {
            assertThat(output).isEqualTo(expected);
            return this;
        }

        public OutputAssert<T> hasValue(final T expected) {
            assertThat(result).isEqualTo(expected);
            return this;
        }
    }

    public static class InputAssert<T> {
        private final Function<Scanner, T> supplier;
        private String input;

        InputAssert(final Function<Scanner, T> supplier) {
            this.supplier = supplier;
        }

        public InputAssert<T> write(final String input) {
            this.input = input;
            return this;
        }

        public InputAssert<T> run(final Consumer<T> action) {
            final Scanner clavier = new Scanner(new StringReader(input));
            final T results = supplier.apply(clavier);
            action.accept(results);
            return this;
        }
    }

    public static class InputOutputAssert<T> {
        private final InputAssert<OutputAssert<T>> delegate;
        private OutputAssert<T> result;

        InputOutputAssert(final Function<Scanner, T> supplier) {
            delegate = withInput(input -> assertOutput(() -> supplier.apply(input)));
        }

        public InputOutputAssert<T> write(final String input) {
            delegate.write(input);
            result = null;
            return this;
        }

        public InputOutputAssert<T> hasOutput(String expected) {
            getResult().hasOutput(expected);
            return this;
        }

        public InputOutputAssert<T> hasValue(final T expected) {
            getResult().hasValue(expected);
            return this;
        }

        private OutputAssert<T> getResult() {
            if (result == null) {
                delegate.run(result -> this.result = result);
            }
            return result;
        }
    }
}

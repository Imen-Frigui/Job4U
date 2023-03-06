/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;


/**
 * This class is an example for using an {@link ObservableInputStream}. It creates its own
 * {@link org.apache.commons.io.input.ObservableInputStream.Observer}, which calculates a checksum using a
 * MessageDigest, for example an MD5 sum.
 * <p>
 * See the MessageDigest section in the
 * <a href= "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest"> Java
 * Cryptography Architecture Standard Algorithm Name Documentation</a> for information about standard algorithm names.
 * </p>
 * <p>
 * <em>Note</em>: Neither {@link ObservableInputStream}, nor {@link MessageDigest}, are thread safe. So is
 * {@link MessageDigestCalculatingInputStream}.
 * </p>
 */
public class MessageDigestCalculatingInputStream extends ObservableInputStream {

    /**
     * Maintains the message digest.
     */
    public static class MessageDigestMaintainingObserver extends Observer {
        private final MessageDigest messageDigest;

        /**
         * Creates an MessageDigestMaintainingObserver for the given MessageDigest.
         * @param messageDigest the message digest to use
         */
        public MessageDigestMaintainingObserver(final MessageDigest messageDigest) {
            this.messageDigest = messageDigest;
        }

        @Override
        public void data(final byte[] input, final int offset, final int length) throws IOException {
            messageDigest.update(input, offset, length);
        }

        @Override
        public void data(final int input) throws IOException {
            messageDigest.update((byte) input);
        }
    }

    /**
     * The default message digest algorithm.
     * <p>
     * The MD5 cryptographic algorithm is weak and should not be used.
     * </p>
     */
    private static final String DEFAULT_ALGORITHM = "MD5";

    /**
     * Gets a MessageDigest object that implements the default digest algorithm.
     *
     * @return a Message Digest object that implements the default algorithm.
     * @throws NoSuchAlgorithmException if no Provider supports a MessageDigestSpi implementation.
     * @see Provider
     */
    static MessageDigest getDefaultMessageDigest() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(DEFAULT_ALGORITHM);
    }

    private final MessageDigest messageDigest;

    /**
     * Creates a new instance, which calculates a signature on the given stream, using a {@link MessageDigest} with the
     * "MD5" algorithm.
     * <p>
     * The MD5 algorithm is weak and should not be used.
     * </p>
     *
     * @param inputStream the stream to calculate the message digest for
     * @throws NoSuchAlgorithmException if no Provider supports a MessageDigestSpi implementation for the specified
     *         algorithm.
     */
    public MessageDigestCalculatingInputStream(final InputStream inputStream) throws NoSuchAlgorithmException {
        this(inputStream, getDefaultMessageDigest());
    }

    /**
     * Creates a new instance, which calculates a signature on the given stream,
     * using the given {@link MessageDigest}.
     * @param inputStream the stream to calculate the message digest for
     * @param messageDigest the message digest to use
     */
    public MessageDigestCalculatingInputStream(final InputStream inputStream, final MessageDigest messageDigest) {
        super(inputStream, new MessageDigestMaintainingObserver(messageDigest));
        this.messageDigest = messageDigest;
    }

    /**
     * Creates a new instance, which calculates a signature on the given stream, using a {@link MessageDigest} with the
     * given algorithm.
     *
     * @param inputStream the stream to calculate the message digest for
     * @param algorithm the name of the algorithm requested. See the MessageDigest section in the
     *        <a href= "https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#MessageDigest">
     *        Java Cryptography Architecture Standard Algorithm Name Documentation</a> for information about standard
     *        algorithm names.
     * @throws NoSuchAlgorithmException if no Provider supports a MessageDigestSpi implementation for the specified
     *         algorithm.
     */
    public MessageDigestCalculatingInputStream(final InputStream inputStream, final String algorithm)
        throws NoSuchAlgorithmException {
        this(inputStream, MessageDigest.getInstance(algorithm));
    }

    /**
     * Gets the {@link MessageDigest}, which is being used for generating the
     * checksum.
     * <p>
     * <em>Note</em>: The checksum will only reflect the data, which has been read so far.
     * This is probably not, what you expect. Make sure, that the complete data has been
     * read, if that is what you want. The easiest way to do so is by invoking
     * {@link #consume()}.
     * </p>
     *
     * @return the message digest used
     */
    public MessageDigest getMessageDigest() {
        return messageDigest;
    }
}

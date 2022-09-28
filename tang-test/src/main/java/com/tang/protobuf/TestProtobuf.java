package com.tang.protobuf;

public final class TestProtobuf {
    private TestProtobuf() {}
    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }
    public interface testBufOrBuilder extends
            // @@protoc_insertion_point(interface_extends:test.testBuf)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>required int32 id = 1;</code>
         * @return Whether the id field is set.
         */
        boolean hasId();
        /**
         * <code>required int32 id = 1;</code>
         * @return The id.
         */
        int getId();

        /**
         * <code>required string name = 2;</code>
         * @return Whether the name field is set.
         */
        boolean hasName();
        /**
         * <code>required string name = 2;</code>
         * @return The name.
         */
        String getName();
        /**
         * <code>required string name = 2;</code>
         * @return The bytes for name.
         */
        com.google.protobuf.ByteString
        getNameBytes();

        /**
         * <code>required int32 age = 3;</code>
         * @return Whether the age field is set.
         */
        boolean hasAge();
        /**
         * <code>required int32 age = 3;</code>
         * @return The age.
         */
        int getAge();
    }
    /**
     * Protobuf type {@code test.testBuf}
     */
    public static final class testBuf extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:test.testBuf)
            testBufOrBuilder {
        private static final long serialVersionUID = 0L;
        // Use testBuf.newBuilder() to construct.
        private testBuf(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }
        private testBuf() {
            name_ = "";
        }

        @Override
        @SuppressWarnings({"unused"})
        protected Object newInstance(
                UnusedPrivateParameter unused) {
            return new testBuf();
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }
        private testBuf(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8: {
                            bitField0_ |= 0x00000001;
                            id_ = input.readInt32();
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            name_ = bs;
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000004;
                            age_ = input.readInt32();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }
        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return TestProtobuf.internal_static_test_testBuf_descriptor;
        }

        @Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return TestProtobuf.internal_static_test_testBuf_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            testBuf.class, Builder.class);
        }

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        /**
         * <code>required int32 id = 1;</code>
         * @return Whether the id field is set.
         */
        @Override
        public boolean hasId() {
            return ((bitField0_ & 0x00000001) != 0);
        }
        /**
         * <code>required int32 id = 1;</code>
         * @return The id.
         */
        @Override
        public int getId() {
            return id_;
        }

        public static final int NAME_FIELD_NUMBER = 2;
        private volatile Object name_;
        /**
         * <code>required string name = 2;</code>
         * @return Whether the name field is set.
         */
        @Override
        public boolean hasName() {
            return ((bitField0_ & 0x00000002) != 0);
        }
        /**
         * <code>required string name = 2;</code>
         * @return The name.
         */
        @Override
        public String getName() {
            Object ref = name_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }
        /**
         * <code>required string name = 2;</code>
         * @return The bytes for name.
         */
        @Override
        public com.google.protobuf.ByteString
        getNameBytes() {
            Object ref = name_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int AGE_FIELD_NUMBER = 3;
        private int age_;
        /**
         * <code>required int32 age = 3;</code>
         * @return Whether the age field is set.
         */
        @Override
        public boolean hasAge() {
            return ((bitField0_ & 0x00000004) != 0);
        }
        /**
         * <code>required int32 age = 3;</code>
         * @return The age.
         */
        @Override
        public int getAge() {
            return age_;
        }

        private byte memoizedIsInitialized = -1;
        @Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasName()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasAge()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeInt32(1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeInt32(3, age_);
            }
            unknownFields.writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(3, age_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof testBuf)) {
                return super.equals(obj);
            }
            testBuf other = (testBuf) obj;

            if (hasId() != other.hasId()) return false;
            if (hasId()) {
                if (getId()
                        != other.getId()) return false;
            }
            if (hasName() != other.hasName()) return false;
            if (hasName()) {
                if (!getName()
                        .equals(other.getName())) return false;
            }
            if (hasAge() != other.hasAge()) return false;
            if (hasAge()) {
                if (getAge()
                        != other.getAge()) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasId()) {
                hash = (37 * hash) + ID_FIELD_NUMBER;
                hash = (53 * hash) + getId();
            }
            if (hasName()) {
                hash = (37 * hash) + NAME_FIELD_NUMBER;
                hash = (53 * hash) + getName().hashCode();
            }
            if (hasAge()) {
                hash = (37 * hash) + AGE_FIELD_NUMBER;
                hash = (53 * hash) + getAge();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static testBuf parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static testBuf parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static testBuf parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static testBuf parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static testBuf parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }
        public static testBuf parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }
        public static testBuf parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static testBuf parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }
        public static testBuf parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }
        public static testBuf parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }
        public static testBuf parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }
        public static testBuf parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() { return newBuilder(); }
        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }
        public static Builder newBuilder(testBuf prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }
        @Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }
        /**
         * Protobuf type {@code test.testBuf}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:test.testBuf)
                testBufOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return TestProtobuf.internal_static_test_testBuf_descriptor;
            }

            @Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return TestProtobuf.internal_static_test_testBuf_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                testBuf.class, Builder.class);
            }

            // Construct using com.zhanghao.test.protobuf.TestProtobuf.testBuf.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }
            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }
            @Override
            public Builder clear() {
                super.clear();
                id_ = 0;
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                age_ = 0;
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return TestProtobuf.internal_static_test_testBuf_descriptor;
            }

            @Override
            public testBuf getDefaultInstanceForType() {
                return testBuf.getDefaultInstance();
            }

            @Override
            public testBuf build() {
                testBuf result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public testBuf buildPartial() {
                testBuf result = new testBuf(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.id_ = id_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.age_ = age_;
                    to_bitField0_ |= 0x00000004;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override
            public Builder clone() {
                return super.clone();
            }
            @Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.setField(field, value);
            }
            @Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }
            @Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }
            @Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, Object value) {
                return super.setRepeatedField(field, index, value);
            }
            @Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return super.addRepeatedField(field, value);
            }
            @Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof testBuf) {
                    return mergeFrom((testBuf)other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(testBuf other) {
                if (other == testBuf.getDefaultInstance()) return this;
                if (other.hasId()) {
                    setId(other.getId());
                }
                if (other.hasName()) {
                    bitField0_ |= 0x00000002;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasAge()) {
                    setAge(other.getAge());
                }
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override
            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (!hasName()) {
                    return false;
                }
                if (!hasAge()) {
                    return false;
                }
                return true;
            }

            @Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                testBuf parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (testBuf) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }
            private int bitField0_;

            private int id_ ;
            /**
             * <code>required int32 id = 1;</code>
             * @return Whether the id field is set.
             */
            @Override
            public boolean hasId() {
                return ((bitField0_ & 0x00000001) != 0);
            }
            /**
             * <code>required int32 id = 1;</code>
             * @return The id.
             */
            @Override
            public int getId() {
                return id_;
            }
            /**
             * <code>required int32 id = 1;</code>
             * @param value The id to set.
             * @return This builder for chaining.
             */
            public Builder setId(int value) {
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required int32 id = 1;</code>
             * @return This builder for chaining.
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                id_ = 0;
                onChanged();
                return this;
            }

            private Object name_ = "";
            /**
             * <code>required string name = 2;</code>
             * @return Whether the name field is set.
             */
            public boolean hasName() {
                return ((bitField0_ & 0x00000002) != 0);
            }
            /**
             * <code>required string name = 2;</code>
             * @return The name.
             */
            public String getName() {
                Object ref = name_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }
            /**
             * <code>required string name = 2;</code>
             * @return The bytes for name.
             */
            public com.google.protobuf.ByteString
            getNameBytes() {
                Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }
            /**
             * <code>required string name = 2;</code>
             * @param value The name to set.
             * @return This builder for chaining.
             */
            public Builder setName(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                name_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required string name = 2;</code>
             * @return This builder for chaining.
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000002);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }
            /**
             * <code>required string name = 2;</code>
             * @param value The bytes for name to set.
             * @return This builder for chaining.
             */
            public Builder setNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                name_ = value;
                onChanged();
                return this;
            }

            private int age_ ;
            /**
             * <code>required int32 age = 3;</code>
             * @return Whether the age field is set.
             */
            @Override
            public boolean hasAge() {
                return ((bitField0_ & 0x00000004) != 0);
            }
            /**
             * <code>required int32 age = 3;</code>
             * @return The age.
             */
            @Override
            public int getAge() {
                return age_;
            }
            /**
             * <code>required int32 age = 3;</code>
             * @param value The age to set.
             * @return This builder for chaining.
             */
            public Builder setAge(int value) {
                bitField0_ |= 0x00000004;
                age_ = value;
                onChanged();
                return this;
            }
            /**
             * <code>required int32 age = 3;</code>
             * @return This builder for chaining.
             */
            public Builder clearAge() {
                bitField0_ = (bitField0_ & ~0x00000004);
                age_ = 0;
                onChanged();
                return this;
            }
            @Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:test.testBuf)
        }

        // @@protoc_insertion_point(class_scope:test.testBuf)
        private static final testBuf DEFAULT_INSTANCE;
        static {
            DEFAULT_INSTANCE = new testBuf();
        }

        public static testBuf getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated public static final com.google.protobuf.Parser<testBuf>
                PARSER = new com.google.protobuf.AbstractParser<testBuf>() {
            @Override
            public testBuf parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new testBuf(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<testBuf> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<testBuf> getParserForType() {
            return PARSER;
        }

        @Override
        public testBuf getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_test_testBuf_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_test_testBuf_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }
    private static  com.google.protobuf.Descriptors.FileDescriptor
            descriptor;
    static {
        String[] descriptorData = {
                "\n\ntest.proto\022\004test\"0\n\007testBuf\022\n\n\002id\030\001 \002(" +
                        "\005\022\014\n\004name\030\002 \002(\t\022\013\n\003age\030\003 \002(\005B*\n\032com.zhan" +
                        "ghao.test.protobufB\014TestProtobuf"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                        });
        internal_static_test_testBuf_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_test_testBuf_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_test_testBuf_descriptor,
                new String[] { "Id", "Name", "Age", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}


/*
 * Copyright 2013 Nicolas Morel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nmorel.gwtjackson.client.ser.array;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.JsonSerializer;
import com.github.nmorel.gwtjackson.client.JsonSerializerParameters;
import com.github.nmorel.gwtjackson.client.stream.JsonWriter;

/**
 * Default {@link JsonSerializer} implementation for array of long.
 *
 * @author Nicolas Morel
 */
public class PrimitiveLongArrayJsonSerializer extends JsonSerializer<long[]> {

    private static final PrimitiveLongArrayJsonSerializer INSTANCE = new PrimitiveLongArrayJsonSerializer();

    /**
     * @return an instance of {@link PrimitiveLongArrayJsonSerializer}
     */
    public static PrimitiveLongArrayJsonSerializer getInstance() {
        return INSTANCE;
    }

    private PrimitiveLongArrayJsonSerializer() { }

    @Override
    protected boolean isEmpty( @Nullable long[] value ) {
        return null == value || value.length == 0;
    }

    @Override
    public void doSerialize( JsonWriter writer, @Nonnull long[] values, JsonSerializationContext ctx, JsonSerializerParameters params ) {
        if ( !ctx.isWriteEmptyJsonArrays() && values.length == 0 ) {
            writer.cancelName();
            return;
        }

        if ( ctx.isWriteSingleElemArraysUnwrapped() && values.length == 1 ) {
            writer.value( values[0] );
        } else {
            writer.beginArray();
            for ( long value : values ) {
                writer.value( value );
            }
            writer.endArray();
        }
    }
}

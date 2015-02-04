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

package com.github.nmorel.gwtjackson.client.options;

import java.util.Map;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.JsonSerializationContext;
import com.github.nmorel.gwtjackson.client.ObjectWriter;
import com.github.nmorel.gwtjackson.shared.options.WriteNullMapValuesOptionTester;
import com.google.gwt.core.client.GWT;

/**
 * @author Nicolas Morel
 */
public class WriteNullMapValuesOptionGwtTest extends GwtJacksonTestCase {

    public interface MapStringStringWriter extends ObjectWriter<Map<String, String>> {

        static MapStringStringWriter INSTANCE = GWT.create( MapStringStringWriter.class );
    }

    public void testWriteNullValues() {
        WriteNullMapValuesOptionTester.INSTANCE.testWriteNullValues( createWriter( MapStringStringWriter.INSTANCE ) );
    }

    public void testWriteNonNullValues() {
        WriteNullMapValuesOptionTester.INSTANCE
                .testWriteNonNullValues( createWriter( MapStringStringWriter.INSTANCE, JsonSerializationContext.builder()
                        .writeNullMapValues( false ).build() ) );
    }
}

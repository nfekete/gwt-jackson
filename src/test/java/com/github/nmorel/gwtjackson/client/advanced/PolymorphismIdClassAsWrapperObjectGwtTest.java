package com.github.nmorel.gwtjackson.client.advanced;

import com.github.nmorel.gwtjackson.client.GwtJacksonTestCase;
import com.github.nmorel.gwtjackson.client.JsonMapper;
import com.github.nmorel.gwtjackson.shared.advanced.PolymorphismIdNameAsWrapperObjectTester;
import com.google.gwt.core.client.GWT;

/** @author Nicolas Morel */
public class PolymorphismIdClassAsWrapperObjectGwtTest extends GwtJacksonTestCase
{
    public interface PolymorphismMapper extends JsonMapper<PolymorphismIdNameAsWrapperObjectTester.Person[]>
    {
        static PolymorphismMapper INSTANCE = GWT.create( PolymorphismMapper.class );
    }

    private PolymorphismIdNameAsWrapperObjectTester tester = PolymorphismIdNameAsWrapperObjectTester.INSTANCE;

    public void testEncoding()
    {
        tester.testEncoding( createEncoder( PolymorphismMapper.INSTANCE ) );
    }

    public void testDecoding()
    {
        tester.testDecoding( createDecoder( PolymorphismMapper.INSTANCE ) );
    }
}

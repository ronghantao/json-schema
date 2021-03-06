/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.json.schema.loader;

import java.io.InputStream;

import org.everit.json.schema.loader.internal.DefaultSchemaClient;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class ResolutionScopeTest {

  private static JSONObject ALL_SCHEMAS;

  static {
    InputStream stream = SchemaLoaderTest.class.getResourceAsStream(
        "/org/everit/jsonvalidator/testschemas.json");
    ALL_SCHEMAS = new JSONObject(new JSONTokener(stream));
  }

  private JSONObject get(final String schemaName) {
    return ALL_SCHEMAS.getJSONObject(schemaName);
  }

  @Test
  public void resolutionScopeTest() {
    SchemaLoader.load(get("resolutionScopeTest"), new SchemaClient() {

      @Override
      public InputStream get(final String url) {
        System.out.println("GET " + url);
        return new DefaultSchemaClient().get(url);
      }
    });
  }

}

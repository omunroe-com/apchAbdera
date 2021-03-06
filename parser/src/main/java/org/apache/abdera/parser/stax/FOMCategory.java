/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  The ASF licenses this file to You
* under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.  For additional information regarding
* copyright in this work, please see the NOTICE file in the top level
* directory of this distribution.
*/
package org.apache.abdera.parser.stax;

import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.namespace.QName;

import org.apache.abdera.factory.Factory;
import org.apache.abdera.model.Category;
import org.apache.abdera.util.Constants;
import org.apache.axiom.om.OMContainer;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMXMLParserWrapper;


public class FOMCategory 
  extends FOMExtensibleElement 
  implements Category {

  private static final long serialVersionUID = -4313042828936786803L;
  
  public FOMCategory() {
    super(Constants.CATEGORY, null, (OMFactory)Factory.INSTANCE);
  }
  
  public FOMCategory(String term) {
    this();
    setTerm(term);
  }
  
  public FOMCategory(
    String term, 
    String scheme, 
    String label) 
      throws URISyntaxException {
    this();
    setTerm(term);
    setScheme(scheme);
    setLabel(label);
  }
  
  public FOMCategory(
    String name,
    OMNamespace namespace,
    OMContainer parent,
    OMFactory factory)
      throws OMException {
    super(name, namespace, parent, factory);
  }
  
  public FOMCategory(
    QName qname,
    OMContainer parent,
    OMFactory factory) {
      super(qname, parent, factory);
  }
  
  public FOMCategory(
    QName qname,
    OMContainer parent, 
    OMFactory factory,
    OMXMLParserWrapper builder) {
      super(qname, parent, factory, builder);
  }
  
  public FOMCategory(
    OMContainer parent, 
    OMFactory factory) {
      super(CATEGORY, parent, factory);
  }
 
  public FOMCategory(
    OMContainer parent, 
    OMFactory factory,
    OMXMLParserWrapper builder) {
      super(CATEGORY, parent, factory, builder);
  }
  
  public String getTerm() {
    return getAttributeValue(TERM);
  }

  public void setTerm(String term) {
    if (term != null)
      setAttributeValue(TERM, term);
    else
      removeAttribute(TERM);
  }

  public URI getScheme() throws URISyntaxException {
    String value = getAttributeValue(SCHEME);
    return (value != null) ? new URI(value) : null;
  }

  public void setScheme(String scheme) throws URISyntaxException {
    if (scheme != null)
      setAttributeValue(SCHEME, (scheme != null) ? new URI(scheme).toString() : null);
    else 
      removeAttribute(SCHEME);
  }
  
  public String getLabel() {
    return getAttributeValue(LABEL);
  }

  public void setLabel(String label) {
    if (label != null)
      setAttributeValue(LABEL, label);
    else
      removeAttribute(LABEL);
  }

  public String getValue() {
    return getText();
  }

  public void setValue(String value) {
    if (value != null)
      setText(value);
    else
      _removeAllChildren();
  }

}

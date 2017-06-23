/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.security.index;

import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.id.ExternalId;
import com.opengamma.master.security.SecurityDescription;
import com.opengamma.util.time.Tenor;

/**
 * Class representing an Swap index (e.g. USISDA10 Index).
 */
@BeanDefinition
@SecurityDescription(type = SwapIndex.INDEX_TYPE, description = "Swap index")
public class SwapIndex extends Index {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The index type.
   */
  public static final String INDEX_TYPE = "SWAP_INDEX";

  /**
   * The tenor of the underlying rate.
   */
  @PropertyDefinition(validate = "notNull")
  private Tenor _tenor;

  /**
   * The external id of the convention.
   */
  @PropertyDefinition(validate = "notNull")
  private ExternalId _conventionId;

  /**
   * For the builder.
   */
  public SwapIndex() {
    super(INDEX_TYPE);
  }

  /**
   * @param name The index name, not null
   * @param tenor The rate tenor, not null
   * @param conventionId The convention id, not null
   */
  public SwapIndex(final String name, final Tenor tenor, final ExternalId conventionId) {
    super(INDEX_TYPE, name);
    setTenor(tenor);
    setConventionId(conventionId);
  }

  /**
   * @param name The index name, not null
   * @param description The description name, not null
   * @param tenor The rate tenor, not null
   * @param conventionId The convention id, not null
   */
  public SwapIndex(final String name, final String description, final Tenor tenor,
      final ExternalId conventionId) {
    super(INDEX_TYPE, name, description);
    setTenor(tenor);
    setConventionId(conventionId);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SwapIndex}.
   * @return the meta-bean, not null
   */
  public static SwapIndex.Meta meta() {
    return SwapIndex.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SwapIndex.Meta.INSTANCE);
  }

  @Override
  public SwapIndex.Meta metaBean() {
    return SwapIndex.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the tenor of the underlying rate.
   * @return the value of the property, not null
   */
  public Tenor getTenor() {
    return _tenor;
  }

  /**
   * Sets the tenor of the underlying rate.
   * @param tenor  the new value of the property, not null
   */
  public void setTenor(Tenor tenor) {
    JodaBeanUtils.notNull(tenor, "tenor");
    this._tenor = tenor;
  }

  /**
   * Gets the the {@code tenor} property.
   * @return the property, not null
   */
  public final Property<Tenor> tenor() {
    return metaBean().tenor().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the external id of the convention.
   * @return the value of the property, not null
   */
  public ExternalId getConventionId() {
    return _conventionId;
  }

  /**
   * Sets the external id of the convention.
   * @param conventionId  the new value of the property, not null
   */
  public void setConventionId(ExternalId conventionId) {
    JodaBeanUtils.notNull(conventionId, "conventionId");
    this._conventionId = conventionId;
  }

  /**
   * Gets the the {@code conventionId} property.
   * @return the property, not null
   */
  public final Property<ExternalId> conventionId() {
    return metaBean().conventionId().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public SwapIndex clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SwapIndex other = (SwapIndex) obj;
      return JodaBeanUtils.equal(getTenor(), other.getTenor()) &&
          JodaBeanUtils.equal(getConventionId(), other.getConventionId()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = hash * 31 + JodaBeanUtils.hashCode(getTenor());
    hash = hash * 31 + JodaBeanUtils.hashCode(getConventionId());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("SwapIndex{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  @Override
  protected void toString(StringBuilder buf) {
    super.toString(buf);
    buf.append("tenor").append('=').append(JodaBeanUtils.toString(getTenor())).append(',').append(' ');
    buf.append("conventionId").append('=').append(JodaBeanUtils.toString(getConventionId())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SwapIndex}.
   */
  public static class Meta extends Index.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tenor} property.
     */
    private final MetaProperty<Tenor> _tenor = DirectMetaProperty.ofReadWrite(
        this, "tenor", SwapIndex.class, Tenor.class);
    /**
     * The meta-property for the {@code conventionId} property.
     */
    private final MetaProperty<ExternalId> _conventionId = DirectMetaProperty.ofReadWrite(
        this, "conventionId", SwapIndex.class, ExternalId.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "tenor",
        "conventionId");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 110246592:  // tenor
          return _tenor;
        case 1520979052:  // conventionId
          return _conventionId;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends SwapIndex> builder() {
      return new DirectBeanBuilder<SwapIndex>(new SwapIndex());
    }

    @Override
    public Class<? extends SwapIndex> beanType() {
      return SwapIndex.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tenor} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Tenor> tenor() {
      return _tenor;
    }

    /**
     * The meta-property for the {@code conventionId} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<ExternalId> conventionId() {
      return _conventionId;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 110246592:  // tenor
          return ((SwapIndex) bean).getTenor();
        case 1520979052:  // conventionId
          return ((SwapIndex) bean).getConventionId();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 110246592:  // tenor
          ((SwapIndex) bean).setTenor((Tenor) newValue);
          return;
        case 1520979052:  // conventionId
          ((SwapIndex) bean).setConventionId((ExternalId) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((SwapIndex) bean)._tenor, "tenor");
      JodaBeanUtils.notNull(((SwapIndex) bean)._conventionId, "conventionId");
      super.validate(bean);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */

package com.opengamma.masterdb.security.hibernate.index;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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

import com.opengamma.masterdb.security.hibernate.IndexWeightingTypeBean;

/**
 * A Hibernate bean representation of {@link EquityIndexBean}.
 */
@BeanDefinition
public class EquityIndexBean extends IndexBean {
  @PropertyDefinition
  private List<EquityIndexComponentBean> _equityComponents;
  @PropertyDefinition
  private IndexWeightingTypeBean _weightingType;

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof EquityIndexBean)) {
      return false;
    }
    EquityIndexBean index = (EquityIndexBean) other;
    return new EqualsBuilder()
      .append(getId(), index.getId())
      .append(getDescription(), index.getDescription())
      .append(getEquityComponents(), index.getEquityComponents())
      .append(getWeightingType(), index.getWeightingType())
      .isEquals();
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder()
      .append(getDescription())
      .append(getEquityComponents())
      .append(getWeightingType())
      .toHashCode();
  }
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code EquityIndexBean}.
   * @return the meta-bean, not null
   */
  public static EquityIndexBean.Meta meta() {
    return EquityIndexBean.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(EquityIndexBean.Meta.INSTANCE);
  }

  @Override
  public EquityIndexBean.Meta metaBean() {
    return EquityIndexBean.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the equityComponents.
   * @return the value of the property
   */
  public List<EquityIndexComponentBean> getEquityComponents() {
    return _equityComponents;
  }

  /**
   * Sets the equityComponents.
   * @param equityComponents  the new value of the property
   */
  public void setEquityComponents(List<EquityIndexComponentBean> equityComponents) {
    this._equityComponents = equityComponents;
  }

  /**
   * Gets the the {@code equityComponents} property.
   * @return the property, not null
   */
  public final Property<List<EquityIndexComponentBean>> equityComponents() {
    return metaBean().equityComponents().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the weightingType.
   * @return the value of the property
   */
  public IndexWeightingTypeBean getWeightingType() {
    return _weightingType;
  }

  /**
   * Sets the weightingType.
   * @param weightingType  the new value of the property
   */
  public void setWeightingType(IndexWeightingTypeBean weightingType) {
    this._weightingType = weightingType;
  }

  /**
   * Gets the the {@code weightingType} property.
   * @return the property, not null
   */
  public final Property<IndexWeightingTypeBean> weightingType() {
    return metaBean().weightingType().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public EquityIndexBean clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("EquityIndexBean{");
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
    buf.append("equityComponents").append('=').append(JodaBeanUtils.toString(getEquityComponents())).append(',').append(' ');
    buf.append("weightingType").append('=').append(JodaBeanUtils.toString(getWeightingType())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code EquityIndexBean}.
   */
  public static class Meta extends IndexBean.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code equityComponents} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<EquityIndexComponentBean>> _equityComponents = DirectMetaProperty.ofReadWrite(
        this, "equityComponents", EquityIndexBean.class, (Class) List.class);
    /**
     * The meta-property for the {@code weightingType} property.
     */
    private final MetaProperty<IndexWeightingTypeBean> _weightingType = DirectMetaProperty.ofReadWrite(
        this, "weightingType", EquityIndexBean.class, IndexWeightingTypeBean.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "equityComponents",
        "weightingType");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -281080901:  // equityComponents
          return _equityComponents;
        case 86270148:  // weightingType
          return _weightingType;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends EquityIndexBean> builder() {
      return new DirectBeanBuilder<EquityIndexBean>(new EquityIndexBean());
    }

    @Override
    public Class<? extends EquityIndexBean> beanType() {
      return EquityIndexBean.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code equityComponents} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<List<EquityIndexComponentBean>> equityComponents() {
      return _equityComponents;
    }

    /**
     * The meta-property for the {@code weightingType} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<IndexWeightingTypeBean> weightingType() {
      return _weightingType;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -281080901:  // equityComponents
          return ((EquityIndexBean) bean).getEquityComponents();
        case 86270148:  // weightingType
          return ((EquityIndexBean) bean).getWeightingType();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -281080901:  // equityComponents
          ((EquityIndexBean) bean).setEquityComponents((List<EquityIndexComponentBean>) newValue);
          return;
        case 86270148:  // weightingType
          ((EquityIndexBean) bean).setWeightingType((IndexWeightingTypeBean) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

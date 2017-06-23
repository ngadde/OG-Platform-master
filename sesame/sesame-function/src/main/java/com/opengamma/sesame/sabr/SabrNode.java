/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.sabr;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Represents a single node on a SABR surface.
 */
@BeanDefinition
public final class SabrNode implements ImmutableBean, Comparable<SabrNode> {

  /**
   * The x-value of the node.
   */
  @PropertyDefinition
  private final double _x;

  /**
   * The y-value of the node.
   */
  @PropertyDefinition
  private final double _y;

  /**
   * The z-value of the node.
   */
  @PropertyDefinition
  private final double _z;

  @Override
  public int compareTo(SabrNode other) {

    if (_x < other._x) {
      return -1;
    } else if (_x > other._x) {
      return 1;
    } else if (_y < other._y) {
      return -1;
    } else if (_y > other._y) {
      return 1;
    } else if (_z < other._z) {
      return -1;
    } else if (_z > other._z) {
      return 1;
    } else {
      return 0;
    }
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SabrNode}.
   * @return the meta-bean, not null
   */
  public static SabrNode.Meta meta() {
    return SabrNode.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SabrNode.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static SabrNode.Builder builder() {
    return new SabrNode.Builder();
  }

  private SabrNode(
      double x,
      double y,
      double z) {
    this._x = x;
    this._y = y;
    this._z = z;
  }

  @Override
  public SabrNode.Meta metaBean() {
    return SabrNode.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the x-value of the node.
   * @return the value of the property
   */
  public double getX() {
    return _x;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the y-value of the node.
   * @return the value of the property
   */
  public double getY() {
    return _y;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the z-value of the node.
   * @return the value of the property
   */
  public double getZ() {
    return _z;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SabrNode other = (SabrNode) obj;
      return JodaBeanUtils.equal(getX(), other.getX()) &&
          JodaBeanUtils.equal(getY(), other.getY()) &&
          JodaBeanUtils.equal(getZ(), other.getZ());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getX());
    hash = hash * 31 + JodaBeanUtils.hashCode(getY());
    hash = hash * 31 + JodaBeanUtils.hashCode(getZ());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("SabrNode{");
    buf.append("x").append('=').append(getX()).append(',').append(' ');
    buf.append("y").append('=').append(getY()).append(',').append(' ');
    buf.append("z").append('=').append(JodaBeanUtils.toString(getZ()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SabrNode}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code x} property.
     */
    private final MetaProperty<Double> _x = DirectMetaProperty.ofImmutable(
        this, "x", SabrNode.class, Double.TYPE);
    /**
     * The meta-property for the {@code y} property.
     */
    private final MetaProperty<Double> _y = DirectMetaProperty.ofImmutable(
        this, "y", SabrNode.class, Double.TYPE);
    /**
     * The meta-property for the {@code z} property.
     */
    private final MetaProperty<Double> _z = DirectMetaProperty.ofImmutable(
        this, "z", SabrNode.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "x",
        "y",
        "z");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 120:  // x
          return _x;
        case 121:  // y
          return _y;
        case 122:  // z
          return _z;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public SabrNode.Builder builder() {
      return new SabrNode.Builder();
    }

    @Override
    public Class<? extends SabrNode> beanType() {
      return SabrNode.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code x} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> x() {
      return _x;
    }

    /**
     * The meta-property for the {@code y} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> y() {
      return _y;
    }

    /**
     * The meta-property for the {@code z} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> z() {
      return _z;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 120:  // x
          return ((SabrNode) bean).getX();
        case 121:  // y
          return ((SabrNode) bean).getY();
        case 122:  // z
          return ((SabrNode) bean).getZ();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code SabrNode}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<SabrNode> {

    private double _x;
    private double _y;
    private double _z;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(SabrNode beanToCopy) {
      this._x = beanToCopy.getX();
      this._y = beanToCopy.getY();
      this._z = beanToCopy.getZ();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 120:  // x
          return _x;
        case 121:  // y
          return _y;
        case 122:  // z
          return _z;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 120:  // x
          this._x = (Double) newValue;
          break;
        case 121:  // y
          this._y = (Double) newValue;
          break;
        case 122:  // z
          this._z = (Double) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public SabrNode build() {
      return new SabrNode(
          _x,
          _y,
          _z);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code x} property in the builder.
     * @param x  the new value
     * @return this, for chaining, not null
     */
    public Builder x(double x) {
      this._x = x;
      return this;
    }

    /**
     * Sets the {@code y} property in the builder.
     * @param y  the new value
     * @return this, for chaining, not null
     */
    public Builder y(double y) {
      this._y = y;
      return this;
    }

    /**
     * Sets the {@code z} property in the builder.
     * @param z  the new value
     * @return this, for chaining, not null
     */
    public Builder z(double z) {
      this._z = z;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("SabrNode.Builder{");
      buf.append("x").append('=').append(JodaBeanUtils.toString(_x)).append(',').append(' ');
      buf.append("y").append('=').append(JodaBeanUtils.toString(_y)).append(',').append(' ');
      buf.append("z").append('=').append(JodaBeanUtils.toString(_z));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
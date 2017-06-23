/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.financial.security.swap;

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.financial.convention.businessday.BusinessDayConvention;
import com.opengamma.financial.convention.daycount.DayCount;
import com.opengamma.financial.convention.frequency.Frequency;
import com.opengamma.id.ExternalId;

/**
 * Abstract base class for an inflation-based leg in a swap.
 */
@BeanDefinition
public abstract class InflationLeg extends SwapLeg {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * For the builder.
   */
  /* package */InflationLeg() {
    super();
  }

  /**
   * @param dayCount The day count, not null
   * @param frequency The frequency, not null
   * @param regionId The region, not null
   * @param businessDayConvention The business day convention, not null
   * @param notional The notional, not null
   * @param eom True if dates follow the EOM convention
   */
  protected InflationLeg(final DayCount dayCount, final Frequency frequency, final ExternalId regionId, final BusinessDayConvention businessDayConvention,
      final Notional notional, final boolean eom) {
    super(dayCount, frequency, regionId, businessDayConvention, notional, eom);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code InflationLeg}.
   * @return the meta-bean, not null
   */
  public static InflationLeg.Meta meta() {
    return InflationLeg.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(InflationLeg.Meta.INSTANCE);
  }

  @Override
  public InflationLeg.Meta metaBean() {
    return InflationLeg.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      return super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(32);
    buf.append("InflationLeg{");
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
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code InflationLeg}.
   */
  public static class Meta extends SwapLeg.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap());

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    public BeanBuilder<? extends InflationLeg> builder() {
      throw new UnsupportedOperationException("InflationLeg is an abstract class");
    }

    @Override
    public Class<? extends InflationLeg> beanType() {
      return InflationLeg.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

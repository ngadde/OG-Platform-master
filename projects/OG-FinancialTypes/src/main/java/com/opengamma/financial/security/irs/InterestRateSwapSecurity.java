/**
 * Copyright (C) 2013 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.security.irs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import org.threeten.bp.LocalDate;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.opengamma.OpenGammaRuntimeException;
import com.opengamma.financial.security.FinancialSecurity;
import com.opengamma.financial.security.FinancialSecurityVisitor;
import com.opengamma.id.ExternalIdBundle;
import com.opengamma.master.security.SecurityDescription;

/**
 * A security for a swap.
 */
@BeanDefinition
@SecurityDescription(type = InterestRateSwapSecurity.SECURITY_TYPE, description = "Interest rate swap")
public final class InterestRateSwapSecurity extends FinancialSecurity {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The security type.
   */
  public static final String SECURITY_TYPE = "INTEREST_RATE_SWAP";

  /**
   * Notional exchange rules.
   */
  @PropertyDefinition(validate = "notNull")
  private NotionalExchange _notionalExchange = NotionalExchange.NO_EXCHANGE;

  /**
   * The effective date.
   */
  @PropertyDefinition(get = "manual")
  private LocalDate _effectiveDate;

  /**
   * The unadjusted maturity.
   */
  @PropertyDefinition(get = "manual")
  private LocalDate _unadjustedMaturityDate;

  /**
   * The swap legs.
   */
  @PropertyDefinition(validate = "notNull")
  private List<InterestRateSwapLeg> _legs;

  @Deprecated  // CSIGNORE
  public InterestRateSwapSecurity(final LocalDate effectiveDate, final LocalDate unAdjustedMaturityDate, final Collection<InterestRateSwapLeg> legs) {
    super(SECURITY_TYPE);
    setEffectiveDate(effectiveDate);
    setUnadjustedMaturityDate(unAdjustedMaturityDate);
    setLegs(Lists.newArrayList(legs));
    Preconditions.checkArgument(getPayLeg().getEffectiveDate() == null, "Pay leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getEffectiveDate() == null, "Rec leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getPayLeg().getUnadjustedMaturityDate() == null, "Pay leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getUnadjustedMaturityDate() == null, "Rec leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
  }

  @Deprecated  // CSIGNORE
  public InterestRateSwapSecurity(final ExternalIdBundle id, final LocalDate effectiveDate, final LocalDate unAdjustedMaturityDate, final Collection<InterestRateSwapLeg> legs) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setEffectiveDate(effectiveDate);
    setUnadjustedMaturityDate(unAdjustedMaturityDate);
    setLegs(Lists.newArrayList(legs));
    Preconditions.checkArgument(getPayLeg().getEffectiveDate() == null, "Pay leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getEffectiveDate() == null, "Rec leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getPayLeg().getUnadjustedMaturityDate() == null, "Pay leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getUnadjustedMaturityDate() == null, "Rec leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
  }

  public InterestRateSwapSecurity(final ExternalIdBundle id, final String name, final LocalDate effectiveDate, final LocalDate unAdjustedMaturityDate, final Collection<InterestRateSwapLeg> legs) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setName(name);
    setEffectiveDate(effectiveDate);
    setUnadjustedMaturityDate(unAdjustedMaturityDate);
    setLegs(Lists.newArrayList(legs));
    Preconditions.checkArgument(getPayLeg().getEffectiveDate() == null, "Pay leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getEffectiveDate() == null, "Rec leg effective date conflict: If effective date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getPayLeg().getUnadjustedMaturityDate() == null, "Pay leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getUnadjustedMaturityDate() == null, "Rec leg termination date conflict: If termination date is set on the swap, then it must not be set on the legs");
  }

  public InterestRateSwapSecurity(final ExternalIdBundle id, final String name, final Collection<InterestRateSwapLeg> legs) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setName(name);
    setEffectiveDate(null);
    setUnadjustedMaturityDate(null);
    setLegs(Lists.newArrayList(legs));
    Preconditions.checkArgument(getPayLeg().getEffectiveDate() != null, "Pay leg effective date missing: If effective date is not set on the swap, then it must be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getEffectiveDate() != null, "Rec leg effective date missing: If effective date is not set on the swap, then it must be set on the legs");
    Preconditions.checkArgument(getPayLeg().getUnadjustedMaturityDate() != null, "Pay leg termination date missing: If termination date is not set on the swap, then it must be set on the legs");
    Preconditions.checkArgument(getReceiveLeg().getUnadjustedMaturityDate() != null, "Rec leg termination date missing: If termination date is not set on the swap, then it must be set on the legs");
  }

  public InterestRateSwapLeg getPayLeg() {
    final Collection<InterestRateSwapLeg> legs = getLegs(PayReceiveType.PAY);
    if (legs.size() == 1) {
      return Iterables.getOnlyElement(legs);
    }
    return null;
  }

  public InterestRateSwapLeg getReceiveLeg() {
    final Collection<InterestRateSwapLeg> legs = getLegs(PayReceiveType.RECEIVE);
    if (legs.size() == 1) {
      return Iterables.getOnlyElement(legs);
    }
    return null;
  }

  public Collection<InterestRateSwapLeg> getLegs(final PayReceiveType payReceiveType) {
    final List<InterestRateSwapLeg> legs = new ArrayList<>();
    for (final InterestRateSwapLeg leg : getLegs()) {
      if (leg.getPayReceiveType().equals(payReceiveType)) {
        legs.add(leg);
      }
    }
    return legs;
  }

  /**
   * If effective date is present at the swap level, that is the value to use.
   * If the effective date is null, then there must be effective dates defined on the legs.
   * In this case return the minimum value between the two legs.
   * @return effective date for the swap
   */
  public LocalDate getEffectiveDate() {
    if (_effectiveDate != null) {
      return _effectiveDate;
    } else {
      LocalDate leg1 = getPayLeg().getEffectiveDate();
      LocalDate leg2 = getReceiveLeg().getEffectiveDate();
      if (leg1 == null || leg2 == null) {
        throw new OpenGammaRuntimeException("Cannot find effective date on swap or both legs");
      }
      if (leg1.isBefore(leg2)) {
        return leg1;
      } else {
        return leg2;
      }
    }
  }

  /**
   * If termination date is present at the swap level, that is the value to use.
   * If the termination date is null, then there must be termination dates defined on the legs.
   * In this case return the maximum value between the two legs.
   * @return termination date for the swap
   */
  public LocalDate getUnadjustedMaturityDate() {
    if (_unadjustedMaturityDate != null) {
      return _unadjustedMaturityDate;
    } else {
      LocalDate leg1 = getPayLeg().getUnadjustedMaturityDate();
      LocalDate leg2 = getReceiveLeg().getUnadjustedMaturityDate();
      if (leg1 == null || leg2 == null) {
        throw new OpenGammaRuntimeException("Cannot find termination date on swap or both legs");
      }
      if (leg1.isAfter(leg2)) {
        return leg1;
      } else {
        return leg2;
      }
    }
  }

  @SuppressWarnings("unchecked")
  public <T extends InterestRateSwapLeg> Collection<T> getLegs(final Class<T> desiredLegClass) {
    //ArgumentChecker.isTrue(desiredLegClass.isAssignableFrom(InterestRateSwapLeg.class),
    //                       "desiredLegClass must be a subtype of InterestRateSwpaLeg: got" + desiredLegClass);
    final List<T> legs = new ArrayList<>();
    for (final InterestRateSwapLeg leg : getLegs()) {
      if (leg.getClass().isAssignableFrom(desiredLegClass)) {
        legs.add((T) leg);
      }
    }
    return legs;
  }

  @Override
  public <T> T accept(final FinancialSecurityVisitor<T> visitor) {
    return visitor.visitInterestRateSwapSecurity(this);
  }

  protected InterestRateSwapSecurity() { //For builder
    super(SECURITY_TYPE);
  }

  @Override
  public String toString() {
    final StringBuilder result = new StringBuilder("IRS ");
    if (getUniqueId() != null) {
      result.append('[').append(getUniqueId().toString()).append("] ").append(' ');
    }
    if (getName() != null && !getName().isEmpty()) {
      result.append(getName());
    } else {
      result.append(String.format("start=%s maturity=%s", getEffectiveDate(), getUnadjustedMaturityDate()));
      for (final InterestRateSwapLeg leg : getLegs()) {
        result.append(" [" + leg + "]");
      }
    }
    return result.toString();
  }

  //TODO: These fields should be immutable and checked when set in constructor or builder. For now add a manual method.
  /**
   * Validate the swap is fully constructed and all necessary parameters are set.
   * Requires at least one PAY and one RECEIVE leg.
   */
  public void validate() {
    String name = "IRS";
    if (getName() != null && getName().length() > 0) {
      name = getName();
    } else if (getUniqueId() != null) {
      name = getUniqueId().toString();
    } else if (getExternalIdBundle() != null && getExternalIdBundle().size() > 0) {
      name = getExternalIdBundle().toString();
    }
    if (getLegs(PayReceiveType.PAY).size() < 1) {
      throw new IllegalArgumentException(name + " needs at least one PAY leg.");
    }
    if (getLegs(PayReceiveType.RECEIVE).size() < 1) {
      throw new IllegalArgumentException(name + " needs at least one RECEIVE leg.");
    }
    try {
      metaBean().validate(this);
      for (InterestRateSwapLeg leg : getLegs()) {
        leg.metaBean().validate(leg);
      }
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException(name + " details invalid: " + ex.getMessage());
    }
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code InterestRateSwapSecurity}.
   * @return the meta-bean, not null
   */
  public static InterestRateSwapSecurity.Meta meta() {
    return InterestRateSwapSecurity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(InterestRateSwapSecurity.Meta.INSTANCE);
  }

  @Override
  public InterestRateSwapSecurity.Meta metaBean() {
    return InterestRateSwapSecurity.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets notional exchange rules.
   * @return the value of the property, not null
   */
  public NotionalExchange getNotionalExchange() {
    return _notionalExchange;
  }

  /**
   * Sets notional exchange rules.
   * @param notionalExchange  the new value of the property, not null
   */
  public void setNotionalExchange(NotionalExchange notionalExchange) {
    JodaBeanUtils.notNull(notionalExchange, "notionalExchange");
    this._notionalExchange = notionalExchange;
  }

  /**
   * Gets the the {@code notionalExchange} property.
   * @return the property, not null
   */
  public Property<NotionalExchange> notionalExchange() {
    return metaBean().notionalExchange().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the effective date.
   * @param effectiveDate  the new value of the property
   */
  public void setEffectiveDate(LocalDate effectiveDate) {
    this._effectiveDate = effectiveDate;
  }

  /**
   * Gets the the {@code effectiveDate} property.
   * @return the property, not null
   */
  public Property<LocalDate> effectiveDate() {
    return metaBean().effectiveDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the unadjusted maturity.
   * @param unadjustedMaturityDate  the new value of the property
   */
  public void setUnadjustedMaturityDate(LocalDate unadjustedMaturityDate) {
    this._unadjustedMaturityDate = unadjustedMaturityDate;
  }

  /**
   * Gets the the {@code unadjustedMaturityDate} property.
   * @return the property, not null
   */
  public Property<LocalDate> unadjustedMaturityDate() {
    return metaBean().unadjustedMaturityDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the swap legs.
   * @return the value of the property, not null
   */
  public List<InterestRateSwapLeg> getLegs() {
    return _legs;
  }

  /**
   * Sets the swap legs.
   * @param legs  the new value of the property, not null
   */
  public void setLegs(List<InterestRateSwapLeg> legs) {
    JodaBeanUtils.notNull(legs, "legs");
    this._legs = legs;
  }

  /**
   * Gets the the {@code legs} property.
   * @return the property, not null
   */
  public Property<List<InterestRateSwapLeg>> legs() {
    return metaBean().legs().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public InterestRateSwapSecurity clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      InterestRateSwapSecurity other = (InterestRateSwapSecurity) obj;
      return JodaBeanUtils.equal(getNotionalExchange(), other.getNotionalExchange()) &&
          JodaBeanUtils.equal(getEffectiveDate(), other.getEffectiveDate()) &&
          JodaBeanUtils.equal(getUnadjustedMaturityDate(), other.getUnadjustedMaturityDate()) &&
          JodaBeanUtils.equal(getLegs(), other.getLegs()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = hash * 31 + JodaBeanUtils.hashCode(getNotionalExchange());
    hash = hash * 31 + JodaBeanUtils.hashCode(getEffectiveDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getUnadjustedMaturityDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getLegs());
    return hash ^ super.hashCode();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code InterestRateSwapSecurity}.
   */
  public static final class Meta extends FinancialSecurity.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code notionalExchange} property.
     */
    private final MetaProperty<NotionalExchange> _notionalExchange = DirectMetaProperty.ofReadWrite(
        this, "notionalExchange", InterestRateSwapSecurity.class, NotionalExchange.class);
    /**
     * The meta-property for the {@code effectiveDate} property.
     */
    private final MetaProperty<LocalDate> _effectiveDate = DirectMetaProperty.ofReadWrite(
        this, "effectiveDate", InterestRateSwapSecurity.class, LocalDate.class);
    /**
     * The meta-property for the {@code unadjustedMaturityDate} property.
     */
    private final MetaProperty<LocalDate> _unadjustedMaturityDate = DirectMetaProperty.ofReadWrite(
        this, "unadjustedMaturityDate", InterestRateSwapSecurity.class, LocalDate.class);
    /**
     * The meta-property for the {@code legs} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<InterestRateSwapLeg>> _legs = DirectMetaProperty.ofReadWrite(
        this, "legs", InterestRateSwapSecurity.class, (Class) List.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "notionalExchange",
        "effectiveDate",
        "unadjustedMaturityDate",
        "legs");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -159410813:  // notionalExchange
          return _notionalExchange;
        case -930389515:  // effectiveDate
          return _effectiveDate;
        case -2038917498:  // unadjustedMaturityDate
          return _unadjustedMaturityDate;
        case 3317797:  // legs
          return _legs;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends InterestRateSwapSecurity> builder() {
      return new DirectBeanBuilder<InterestRateSwapSecurity>(new InterestRateSwapSecurity());
    }

    @Override
    public Class<? extends InterestRateSwapSecurity> beanType() {
      return InterestRateSwapSecurity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code notionalExchange} property.
     * @return the meta-property, not null
     */
    public MetaProperty<NotionalExchange> notionalExchange() {
      return _notionalExchange;
    }

    /**
     * The meta-property for the {@code effectiveDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> effectiveDate() {
      return _effectiveDate;
    }

    /**
     * The meta-property for the {@code unadjustedMaturityDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> unadjustedMaturityDate() {
      return _unadjustedMaturityDate;
    }

    /**
     * The meta-property for the {@code legs} property.
     * @return the meta-property, not null
     */
    public MetaProperty<List<InterestRateSwapLeg>> legs() {
      return _legs;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -159410813:  // notionalExchange
          return ((InterestRateSwapSecurity) bean).getNotionalExchange();
        case -930389515:  // effectiveDate
          return ((InterestRateSwapSecurity) bean).getEffectiveDate();
        case -2038917498:  // unadjustedMaturityDate
          return ((InterestRateSwapSecurity) bean).getUnadjustedMaturityDate();
        case 3317797:  // legs
          return ((InterestRateSwapSecurity) bean).getLegs();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -159410813:  // notionalExchange
          ((InterestRateSwapSecurity) bean).setNotionalExchange((NotionalExchange) newValue);
          return;
        case -930389515:  // effectiveDate
          ((InterestRateSwapSecurity) bean).setEffectiveDate((LocalDate) newValue);
          return;
        case -2038917498:  // unadjustedMaturityDate
          ((InterestRateSwapSecurity) bean).setUnadjustedMaturityDate((LocalDate) newValue);
          return;
        case 3317797:  // legs
          ((InterestRateSwapSecurity) bean).setLegs((List<InterestRateSwapLeg>) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((InterestRateSwapSecurity) bean)._notionalExchange, "notionalExchange");
      JodaBeanUtils.notNull(((InterestRateSwapSecurity) bean)._legs, "legs");
      super.validate(bean);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

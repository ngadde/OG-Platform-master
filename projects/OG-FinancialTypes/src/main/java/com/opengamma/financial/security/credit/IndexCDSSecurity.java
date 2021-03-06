/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.security.credit;

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

import com.opengamma.core.link.ResolvableSecurityLink;
import com.opengamma.core.link.SecurityLink;
import com.opengamma.financial.security.FinancialSecurity;
import com.opengamma.financial.security.FinancialSecurityVisitor;
import com.opengamma.financial.security.swap.InterestRateNotional;
import com.opengamma.id.ExternalId;
import com.opengamma.id.ExternalIdBundle;
import com.opengamma.master.security.SecurityDescription;
import com.opengamma.util.time.Tenor;

/**
 * A credit security based on an underlying CDS Index.
 */
@BeanDefinition
@SecurityDescription(type = IndexCDSSecurity.SECURITY_TYPE, description = "Index CDS")
public class IndexCDSSecurity extends FinancialSecurity {

  /** Serialization version */
  private static final long serialVersionUID = 1L;

  /**
   * The security type
   */
  public static final String SECURITY_TYPE = "INDEX_CDS";

  /**
   * The trade date, aka T.
   */
  @PropertyDefinition(validate = "notNull")
  private LocalDate _tradeDate;

  /**
   * The maturity date. Corresponds to the trade date plus a valid tenor listed in the index definition.
   */
  @PropertyDefinition(validate = "notNull")
  private LocalDate _maturityDate;

  /**
   * Is protection being bought?
   */
  @PropertyDefinition(validate = "notNull")
  private boolean _buyProtection;

  /**
   * The reference entity. The underlying index identifier for the CDS Index.
   */
  @PropertyDefinition(validate = "notNull")
  private SecurityLink<IndexCDSDefinitionSecurity> _underlyingIndex;

  /**
   * The notional.
   */
  @PropertyDefinition(validate = "notNull")
  private InterestRateNotional _notional;


  /**
   * Constructor for Joda bean usage.
   */
  IndexCDSSecurity() {
    super(SECURITY_TYPE);
  }

  /**
   * An Index CDS
   *
   * @param id identifier for this index cds, not null
   * @param buy is protection being bought, not null
   * @param underlyingIndex the underling index definition identifier, not null
   * @param maturityDate the maturity date, not null
   * @param tradeDate the trade date, not null
   * @param notional the notional, not null
   */
  public IndexCDSSecurity(ExternalIdBundle id, final boolean buy,
                          final SecurityLink<IndexCDSDefinitionSecurity> underlyingIndex,
                          final LocalDate tradeDate, LocalDate maturityDate, final InterestRateNotional notional) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setBuyProtection(buy);
    setUnderlyingIndex(underlyingIndex);
    setTradeDate(tradeDate);
    setMaturityDate(maturityDate);
    setNotional(notional);
  }

  /**
   * An Index CDS
   *
   * @param id identifier for this index cds, not null
   * @param buy is protection being bought, not null
   * @param underlyingIndex the underling index definition identifier, not null
   * @param maturityDate the maturity date, not null
   * @param tradeDate the trade date, not null
   * @param notional the notional, not null
   */
  public IndexCDSSecurity(ExternalIdBundle id, final boolean buy, final ExternalId underlyingIndex,
                          final LocalDate tradeDate, LocalDate maturityDate,  final InterestRateNotional notional) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setBuyProtection(buy);
    setUnderlyingIndex(SecurityLink.<IndexCDSDefinitionSecurity>resolvable(underlyingIndex));
    setTradeDate(tradeDate);
    setMaturityDate(maturityDate);
    setNotional(notional);
  }

  /**
   * An Index CDS
   *
   * @param id identifier for this index cds, not null
   * @param name the descriptive name for the security, not null
   * @param buy is protection being bought, not null
   * @param underlyingIndex the underling index definition (generally a RED code), not null
   * @param maturityDate the the maturity date, not null
   * @param tradeDate the trade date, not null
   * @param notional the notional, not null
   */
  public IndexCDSSecurity(ExternalIdBundle id, String name, final boolean buy,
                          final SecurityLink<IndexCDSDefinitionSecurity> underlyingIndex,
                          final LocalDate tradeDate, LocalDate maturityDate, final InterestRateNotional notional) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setName(name);
    setBuyProtection(buy);
    setUnderlyingIndex(underlyingIndex);
    setTradeDate(tradeDate);
    setMaturityDate(maturityDate);
    setNotional(notional);
  }

  /**
   * An Index CDS
   *
   * @param id identifier for this index cds, not null
   * @param name the descriptive name for the security, not null
   * @param buy is protection being bought, not null
   * @param underlyingIndex the underling index definition (generally a RED code), not null
   * @param maturityDate the maturity date, not null
   * @param tradeDate the trade date, not null
   * @param notional the notional, not null
   */
  public IndexCDSSecurity(ExternalIdBundle id, String name, final boolean buy, final ExternalId underlyingIndex,
                          final LocalDate tradeDate, LocalDate maturityDate, final InterestRateNotional notional) {
    super(SECURITY_TYPE);
    setExternalIdBundle(id);
    setName(name);
    setBuyProtection(buy);
    setUnderlyingIndex(SecurityLink.<IndexCDSDefinitionSecurity>resolvable(underlyingIndex));
    setMaturityDate(maturityDate);
    setTradeDate(tradeDate);
    setNotional(notional);
  }

  @Override
  public <T> T accept(FinancialSecurityVisitor<T> visitor) {
    return visitor.visitIndexCDSSecurity(this);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code IndexCDSSecurity}.
   * @return the meta-bean, not null
   */
  public static IndexCDSSecurity.Meta meta() {
    return IndexCDSSecurity.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(IndexCDSSecurity.Meta.INSTANCE);
  }

  @Override
  public IndexCDSSecurity.Meta metaBean() {
    return IndexCDSSecurity.Meta.INSTANCE;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the trade date, aka T.
   * @return the value of the property, not null
   */
  public LocalDate getTradeDate() {
    return _tradeDate;
  }

  /**
   * Sets the trade date, aka T.
   * @param tradeDate  the new value of the property, not null
   */
  public void setTradeDate(LocalDate tradeDate) {
    JodaBeanUtils.notNull(tradeDate, "tradeDate");
    this._tradeDate = tradeDate;
  }

  /**
   * Gets the the {@code tradeDate} property.
   * @return the property, not null
   */
  public final Property<LocalDate> tradeDate() {
    return metaBean().tradeDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the maturity date. Corresponds to the trade date plus a valid tenor listed in the index definition.
   * @return the value of the property, not null
   */
  public LocalDate getMaturityDate() {
    return _maturityDate;
  }

  /**
   * Sets the maturity date. Corresponds to the trade date plus a valid tenor listed in the index definition.
   * @param maturityDate  the new value of the property, not null
   */
  public void setMaturityDate(LocalDate maturityDate) {
    JodaBeanUtils.notNull(maturityDate, "maturityDate");
    this._maturityDate = maturityDate;
  }

  /**
   * Gets the the {@code maturityDate} property.
   * @return the property, not null
   */
  public final Property<LocalDate> maturityDate() {
    return metaBean().maturityDate().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets is protection being bought?
   * @return the value of the property, not null
   */
  public boolean isBuyProtection() {
    return _buyProtection;
  }

  /**
   * Sets is protection being bought?
   * @param buyProtection  the new value of the property, not null
   */
  public void setBuyProtection(boolean buyProtection) {
    JodaBeanUtils.notNull(buyProtection, "buyProtection");
    this._buyProtection = buyProtection;
  }

  /**
   * Gets the the {@code buyProtection} property.
   * @return the property, not null
   */
  public final Property<Boolean> buyProtection() {
    return metaBean().buyProtection().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the reference entity. The underlying index identifier for the CDS Index.
   * @return the value of the property, not null
   */
  public SecurityLink<IndexCDSDefinitionSecurity> getUnderlyingIndex() {
    return _underlyingIndex;
  }

  /**
   * Sets the reference entity. The underlying index identifier for the CDS Index.
   * @param underlyingIndex  the new value of the property, not null
   */
  public void setUnderlyingIndex(SecurityLink<IndexCDSDefinitionSecurity> underlyingIndex) {
    JodaBeanUtils.notNull(underlyingIndex, "underlyingIndex");
    this._underlyingIndex = underlyingIndex;
  }

  /**
   * Gets the the {@code underlyingIndex} property.
   * @return the property, not null
   */
  public final Property<SecurityLink<IndexCDSDefinitionSecurity>> underlyingIndex() {
    return metaBean().underlyingIndex().createProperty(this);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the notional.
   * @return the value of the property, not null
   */
  public InterestRateNotional getNotional() {
    return _notional;
  }

  /**
   * Sets the notional.
   * @param notional  the new value of the property, not null
   */
  public void setNotional(InterestRateNotional notional) {
    JodaBeanUtils.notNull(notional, "notional");
    this._notional = notional;
  }

  /**
   * Gets the the {@code notional} property.
   * @return the property, not null
   */
  public final Property<InterestRateNotional> notional() {
    return metaBean().notional().createProperty(this);
  }

  //-----------------------------------------------------------------------
  @Override
  public IndexCDSSecurity clone() {
    return JodaBeanUtils.cloneAlways(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      IndexCDSSecurity other = (IndexCDSSecurity) obj;
      return JodaBeanUtils.equal(getTradeDate(), other.getTradeDate()) &&
          JodaBeanUtils.equal(getMaturityDate(), other.getMaturityDate()) &&
          (isBuyProtection() == other.isBuyProtection()) &&
          JodaBeanUtils.equal(getUnderlyingIndex(), other.getUnderlyingIndex()) &&
          JodaBeanUtils.equal(getNotional(), other.getNotional()) &&
          super.equals(obj);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = hash * 31 + JodaBeanUtils.hashCode(getTradeDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getMaturityDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(isBuyProtection());
    hash = hash * 31 + JodaBeanUtils.hashCode(getUnderlyingIndex());
    hash = hash * 31 + JodaBeanUtils.hashCode(getNotional());
    return hash ^ super.hashCode();
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(192);
    buf.append("IndexCDSSecurity{");
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
    buf.append("tradeDate").append('=').append(JodaBeanUtils.toString(getTradeDate())).append(',').append(' ');
    buf.append("maturityDate").append('=').append(JodaBeanUtils.toString(getMaturityDate())).append(',').append(' ');
    buf.append("buyProtection").append('=').append(JodaBeanUtils.toString(isBuyProtection())).append(',').append(' ');
    buf.append("underlyingIndex").append('=').append(JodaBeanUtils.toString(getUnderlyingIndex())).append(',').append(' ');
    buf.append("notional").append('=').append(JodaBeanUtils.toString(getNotional())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code IndexCDSSecurity}.
   */
  public static class Meta extends FinancialSecurity.Meta {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code tradeDate} property.
     */
    private final MetaProperty<LocalDate> _tradeDate = DirectMetaProperty.ofReadWrite(
        this, "tradeDate", IndexCDSSecurity.class, LocalDate.class);
    /**
     * The meta-property for the {@code maturityDate} property.
     */
    private final MetaProperty<LocalDate> _maturityDate = DirectMetaProperty.ofReadWrite(
        this, "maturityDate", IndexCDSSecurity.class, LocalDate.class);
    /**
     * The meta-property for the {@code buyProtection} property.
     */
    private final MetaProperty<Boolean> _buyProtection = DirectMetaProperty.ofReadWrite(
        this, "buyProtection", IndexCDSSecurity.class, Boolean.TYPE);
    /**
     * The meta-property for the {@code underlyingIndex} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<SecurityLink<IndexCDSDefinitionSecurity>> _underlyingIndex = DirectMetaProperty.ofReadWrite(
        this, "underlyingIndex", IndexCDSSecurity.class, (Class) SecurityLink.class);
    /**
     * The meta-property for the {@code notional} property.
     */
    private final MetaProperty<InterestRateNotional> _notional = DirectMetaProperty.ofReadWrite(
        this, "notional", IndexCDSSecurity.class, InterestRateNotional.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, (DirectMetaPropertyMap) super.metaPropertyMap(),
        "tradeDate",
        "maturityDate",
        "buyProtection",
        "underlyingIndex",
        "notional");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 752419634:  // tradeDate
          return _tradeDate;
        case -414641441:  // maturityDate
          return _maturityDate;
        case 1154909695:  // buyProtection
          return _buyProtection;
        case -834075787:  // underlyingIndex
          return _underlyingIndex;
        case 1585636160:  // notional
          return _notional;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends IndexCDSSecurity> builder() {
      return new DirectBeanBuilder<IndexCDSSecurity>(new IndexCDSSecurity());
    }

    @Override
    public Class<? extends IndexCDSSecurity> beanType() {
      return IndexCDSSecurity.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code tradeDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<LocalDate> tradeDate() {
      return _tradeDate;
    }

    /**
     * The meta-property for the {@code maturityDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<LocalDate> maturityDate() {
      return _maturityDate;
    }

    /**
     * The meta-property for the {@code buyProtection} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Boolean> buyProtection() {
      return _buyProtection;
    }

    /**
     * The meta-property for the {@code underlyingIndex} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<SecurityLink<IndexCDSDefinitionSecurity>> underlyingIndex() {
      return _underlyingIndex;
    }

    /**
     * The meta-property for the {@code notional} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<InterestRateNotional> notional() {
      return _notional;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 752419634:  // tradeDate
          return ((IndexCDSSecurity) bean).getTradeDate();
        case -414641441:  // maturityDate
          return ((IndexCDSSecurity) bean).getMaturityDate();
        case 1154909695:  // buyProtection
          return ((IndexCDSSecurity) bean).isBuyProtection();
        case -834075787:  // underlyingIndex
          return ((IndexCDSSecurity) bean).getUnderlyingIndex();
        case 1585636160:  // notional
          return ((IndexCDSSecurity) bean).getNotional();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 752419634:  // tradeDate
          ((IndexCDSSecurity) bean).setTradeDate((LocalDate) newValue);
          return;
        case -414641441:  // maturityDate
          ((IndexCDSSecurity) bean).setMaturityDate((LocalDate) newValue);
          return;
        case 1154909695:  // buyProtection
          ((IndexCDSSecurity) bean).setBuyProtection((Boolean) newValue);
          return;
        case -834075787:  // underlyingIndex
          ((IndexCDSSecurity) bean).setUnderlyingIndex((SecurityLink<IndexCDSDefinitionSecurity>) newValue);
          return;
        case 1585636160:  // notional
          ((IndexCDSSecurity) bean).setNotional((InterestRateNotional) newValue);
          return;
      }
      super.propertySet(bean, propertyName, newValue, quiet);
    }

    @Override
    protected void validate(Bean bean) {
      JodaBeanUtils.notNull(((IndexCDSSecurity) bean)._tradeDate, "tradeDate");
      JodaBeanUtils.notNull(((IndexCDSSecurity) bean)._maturityDate, "maturityDate");
      JodaBeanUtils.notNull(((IndexCDSSecurity) bean)._buyProtection, "buyProtection");
      JodaBeanUtils.notNull(((IndexCDSSecurity) bean)._underlyingIndex, "underlyingIndex");
      JodaBeanUtils.notNull(((IndexCDSSecurity) bean)._notional, "notional");
      super.validate(bean);
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

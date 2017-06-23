/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.financial.analytics.parameters;

import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.time.Tenor;

/**
 * Represents a table of volatility entries. An entry
 * generally consists of the volatility between a start
 * tenor (inclusive) and the end tenor (exclusive). This
 * table holds the set of entries and checks they form
 * a coherent definition.
 * <p>
 * Specifically, it checks that:
 * <ul>
 *   <li>there is at least one entry in the table</li>
 *   <li>the first entry in the table has a start tenor of 0</li>
 *   <li>the last entry in the table has no end tenor specified</li>
 *   <li>if there is more than one entry, the start tenor of an
 *   entry matches the end tenor of the preceding one</li>
 * </ul>
 */
@BeanDefinition
public class HullWhiteOneFactorVolatilityTable implements ImmutableBean {

  /**
   * The set of volatility entries that make up the table. These will
   * be sorted in their natural order (start tenor ascending).
   * <p>
   * Will be validated to ensure that a contiguous range of entries is
   * specified, with the start tenor of the first entry set to zero
   * and the end tenor of the last entry set to null.
   */
  @PropertyDefinition(validate = "notNull")
  private final SortedSet<HullWhiteOneFactorVolatilityEntry> _entries;

  /**
   * Need to validate that:
   * <ul>
   *   <li>there is at least one entry in the table</li>
   *   <li>the first entry in the table has a start tenor of 0</li>
   *   <li>the last entry in the table has no end tenor specified</li>
   *   <li>if there is more than one entry, the start tenor of an
   *   entry matches the end tenor of the preceding one</li>
   * </ul>
   * Note that there is no need to check for null entries as the Guava
   * ImmutableSortedSet which joda-beans creates will not accept nulls.
   */
  @ImmutableValidator
  private void validate() {
    ArgumentChecker.notEmpty(_entries, "_entries");

    // Convert to list so we have direct element access - by definition
    // the set is already in the correct order
    ImmutableList<HullWhiteOneFactorVolatilityEntry> entryList = ImmutableList.copyOf(_entries);

    for (int i = 0; i < entryList.size(); i++) {

      Tenor start = entryList.get(i).getStartTenor();
      if (i == 0) {
        ArgumentChecker.isTrue(start.equals(Tenor.ofDays(0)),
                               "Start tenor of first entry should be Tenor[P0D] but was [{}]", start);
      } else {
        Tenor previousEnd = entryList.get(i - 1).getEndTenor();
        ArgumentChecker.isTrue(start.equals(previousEnd),
                               "Start tenor [{}] does not equal previous end tenor [{}]", start, previousEnd);
      }

      if (i == entryList.size() - 1) {
        Tenor end = entryList.get(i).getEndTenor();
        ArgumentChecker.isTrue(end == null, "End tenor of last entry should not have a value but was [{}]", end);
      }
    }
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code HullWhiteOneFactorVolatilityTable}.
   * @return the meta-bean, not null
   */
  public static HullWhiteOneFactorVolatilityTable.Meta meta() {
    return HullWhiteOneFactorVolatilityTable.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(HullWhiteOneFactorVolatilityTable.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static HullWhiteOneFactorVolatilityTable.Builder builder() {
    return new HullWhiteOneFactorVolatilityTable.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected HullWhiteOneFactorVolatilityTable(HullWhiteOneFactorVolatilityTable.Builder builder) {
    JodaBeanUtils.notNull(builder._entries, "entries");
    this._entries = ImmutableSortedSet.copyOfSorted(builder._entries);
    validate();
  }

  @Override
  public HullWhiteOneFactorVolatilityTable.Meta metaBean() {
    return HullWhiteOneFactorVolatilityTable.Meta.INSTANCE;
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
   * Gets the set of volatility entries that make up the table. These will
   * be sorted in their natural order (start tenor ascending).
   * <p>
   * Will be validated to ensure that a contiguous range of entries is
   * specified, with the start tenor of the first entry set to zero
   * and the end tenor of the last entry set to null.
   * @return the value of the property, not null
   */
  public SortedSet<HullWhiteOneFactorVolatilityEntry> getEntries() {
    return _entries;
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
      HullWhiteOneFactorVolatilityTable other = (HullWhiteOneFactorVolatilityTable) obj;
      return JodaBeanUtils.equal(getEntries(), other.getEntries());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getEntries());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("HullWhiteOneFactorVolatilityTable{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("entries").append('=').append(JodaBeanUtils.toString(getEntries())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code HullWhiteOneFactorVolatilityTable}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code entries} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<SortedSet<HullWhiteOneFactorVolatilityEntry>> _entries = DirectMetaProperty.ofImmutable(
        this, "entries", HullWhiteOneFactorVolatilityTable.class, (Class) SortedSet.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> _metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "entries");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1591573360:  // entries
          return _entries;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public HullWhiteOneFactorVolatilityTable.Builder builder() {
      return new HullWhiteOneFactorVolatilityTable.Builder();
    }

    @Override
    public Class<? extends HullWhiteOneFactorVolatilityTable> beanType() {
      return HullWhiteOneFactorVolatilityTable.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return _metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code entries} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<SortedSet<HullWhiteOneFactorVolatilityEntry>> entries() {
      return _entries;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1591573360:  // entries
          return ((HullWhiteOneFactorVolatilityTable) bean).getEntries();
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
   * The bean-builder for {@code HullWhiteOneFactorVolatilityTable}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<HullWhiteOneFactorVolatilityTable> {

    private SortedSet<HullWhiteOneFactorVolatilityEntry> _entries = new TreeSet<HullWhiteOneFactorVolatilityEntry>();

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(HullWhiteOneFactorVolatilityTable beanToCopy) {
      this._entries = new TreeSet<HullWhiteOneFactorVolatilityEntry>(beanToCopy.getEntries());
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1591573360:  // entries
          return _entries;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1591573360:  // entries
          this._entries = (SortedSet<HullWhiteOneFactorVolatilityEntry>) newValue;
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
    public HullWhiteOneFactorVolatilityTable build() {
      return new HullWhiteOneFactorVolatilityTable(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code entries} property in the builder.
     * @param entries  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder entries(SortedSet<HullWhiteOneFactorVolatilityEntry> entries) {
      JodaBeanUtils.notNull(entries, "entries");
      this._entries = entries;
      return this;
    }

    /**
     * Sets the {@code entries} property in the builder
     * from an array of objects.
     * @param entries  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder entries(HullWhiteOneFactorVolatilityEntry... entries) {
      return entries(new TreeSet<HullWhiteOneFactorVolatilityEntry>(Arrays.asList(entries)));
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("HullWhiteOneFactorVolatilityTable.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("entries").append('=').append(JodaBeanUtils.toString(_entries)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
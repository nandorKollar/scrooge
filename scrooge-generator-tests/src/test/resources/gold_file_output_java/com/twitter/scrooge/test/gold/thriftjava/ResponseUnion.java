/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.twitter.scrooge.test.gold.thriftjava;

import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class ResponseUnion extends TUnion<ResponseUnion, ResponseUnion._Fields> {
  private static final TStruct STRUCT_DESC = new TStruct("ResponseUnion");

  private static final TField ID_FIELD_DESC = new TField("id", TType.I64, (short)1);
  private static final TField DETAILS_FIELD_DESC = new TField("details", TType.STRING, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    ID((short)1, "id"),
    DETAILS((short)2, "details");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // DETAILS
          return DETAILS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new FieldMetaData("id", TFieldRequirementType.DEFAULT,
      new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.DETAILS, new FieldMetaData("details", TFieldRequirementType.DEFAULT,
      new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(ResponseUnion.class, metaDataMap);
  }


  public ResponseUnion() {
    super();
  }

  public ResponseUnion(_Fields setField, Object value) {
    super(setField, value);
  }

  public ResponseUnion(ResponseUnion other) {
    super(other);
  }

  public ResponseUnion deepCopy() {
    return new ResponseUnion(this);
  }

  public static ResponseUnion id(long value) {
    ResponseUnion x = new ResponseUnion();
    x.setId(value);
    return x;
  }
  public static ResponseUnion details(String value) {
    ResponseUnion x = new ResponseUnion();
    x.setDetails(value);
    return x;
  }

  @java.lang.Override
  protected void checkType(_Fields setField, Object value) throws ClassCastException {
    switch (setField) {
      case ID:
        if (value instanceof Long) {
          break;
        }
        throw new ClassCastException("Was expecting value of type Long for field 'id', but got " + value.getClass().getSimpleName());
      case DETAILS:
        if (value instanceof String) {
          break;
        }
        throw new ClassCastException("Was expecting value of type String for field 'details', but got " + value.getClass().getSimpleName());
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @java.lang.Override
  protected Object readValue(TProtocol iprot, TField field) throws TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case ID:
          if (field.type == ID_FIELD_DESC.type) {
            Long id;
            id = iprot.readI64();

            return id;
          } else {
            TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case DETAILS:
          if (field.type == DETAILS_FIELD_DESC.type) {
            String details;
            details = iprot.readString();

            return details;
          } else {
            TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @java.lang.Override
  protected void writeValue(TProtocol oprot) throws TException {
    switch (setField_) {
      case ID:
        Long id = (Long)value_;
        oprot.writeI64(id);

        return;
      case DETAILS:
        String details = (String)value_;
        oprot.writeString(details);

        return;
      default:
        throw new IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @java.lang.Override
  protected TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case ID:
        return ID_FIELD_DESC;
      case DETAILS:
        return DETAILS_FIELD_DESC;
      default:
        throw new IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @java.lang.Override
  protected TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @java.lang.Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public long getId() {
    if (getSetField() == _Fields.ID) {
      return (Long)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'id' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setId(long value) {
    setField_ = _Fields.ID;
    value_ = value;
  }
  public String getDetails() {
    if (getSetField() == _Fields.DETAILS) {
      return (String)getFieldValue();
    } else {
      throw new RuntimeException("Cannot get field 'details' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setDetails(String value) {
    if (value == null) throw new NullPointerException();
    setField_ = _Fields.DETAILS;
    value_ = value;
  }

  public boolean equals(Object other) {
    if (other instanceof ResponseUnion) {
      return equals((ResponseUnion)other);
    } else {
      return false;
    }
  }

  public boolean equals(ResponseUnion other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @java.lang.Override
  public int compareTo(ResponseUnion other) {
    int lastComparison = TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder hcb = new HashCodeBuilder();
    hcb.append(this.getClass().getName());
    TFieldIdEnum setField = getSetField();
    if (setField != null) {
      hcb.append(setField.getThriftFieldId());
      Object value = getFieldValue();
      if (value instanceof TEnum) {
        hcb.append(((TEnum)getFieldValue()).getValue());
      } else {
        hcb.append(value);
      }
    }
    return hcb.toHashCode();
  }
}


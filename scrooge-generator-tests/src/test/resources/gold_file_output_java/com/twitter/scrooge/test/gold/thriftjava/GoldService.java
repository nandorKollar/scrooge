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

import com.twitter.scrooge.TReusableBuffer;
import com.twitter.scrooge.TReusableMemoryTransport;
import com.twitter.util.Future;
import com.twitter.util.Function;
import com.twitter.util.Function2;
import com.twitter.util.Try;
import com.twitter.util.Return;
import com.twitter.util.Throw;
import com.twitter.finagle.thrift.DeserializeCtx;
import com.twitter.finagle.thrift.ThriftClientRequest;

public class GoldService {
  public interface Iface {
    public Response doGreatThings(Request request) throws OverCapacityException, TException;
  }

  public interface AsyncIface {
    public void doGreatThings(Request request, AsyncMethodCallback<AsyncClient.doGreatThings_call> resultHandler) throws TException;
  }

  public interface ServiceIface {
    public Future<Response> doGreatThings(Request request);
  }

  public static class Client implements TServiceClient, Iface {
    public static class Factory implements TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(TProtocol iprot, TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(TProtocol prot)
    {
      this(prot, prot);
    }

    public Client(TProtocol iprot, TProtocol oprot)
    {
      iprot_ = iprot;
      oprot_ = oprot;
    }

    protected TProtocol iprot_;
    protected TProtocol oprot_;

    protected int seqid_;

    public TProtocol getInputProtocol()
    {
      return this.iprot_;
    }

    public TProtocol getOutputProtocol()
    {
      return this.oprot_;
    }

    public Response doGreatThings(Request request) throws OverCapacityException, TException
    {
      send_doGreatThings(request);
      return recv_doGreatThings();
    }

    public void send_doGreatThings(Request request) throws TException
    {
      oprot_.writeMessageBegin(new TMessage("doGreatThings", TMessageType.CALL, ++seqid_));
      doGreatThings_args __args__ = new doGreatThings_args();
      __args__.setRequest(request);
      __args__.write(oprot_);
      oprot_.writeMessageEnd();
      oprot_.getTransport().flush();
    }

    public Response recv_doGreatThings() throws OverCapacityException, TException
    {
      TMessage msg = iprot_.readMessageBegin();
      if (msg.type == TMessageType.EXCEPTION) {
        TApplicationException x = TApplicationException.read(iprot_);
        iprot_.readMessageEnd();
        throw x;
      }
      if (msg.seqid != seqid_) {
        throw new TApplicationException(TApplicationException.BAD_SEQUENCE_ID, "doGreatThings failed: out of sequence response");
      }
      doGreatThings_result result = new doGreatThings_result();
      result.read(iprot_);
      iprot_.readMessageEnd();
      if (result.isSetSuccess()) {
        return result.success;
      }
      if (result.ex != null) {
        throw result.ex;
      }
      throw new TApplicationException(TApplicationException.MISSING_RESULT, "doGreatThings failed: unknown result");
    }
  }

  public static class AsyncClient extends TAsyncClient implements AsyncIface {
    public static class Factory implements TAsyncClientFactory<AsyncClient> {
      private final TAsyncClientManager clientManager;
      private final TProtocolFactory protocolFactory;
      public Factory(TAsyncClientManager clientManager, TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(TProtocolFactory protocolFactory, TAsyncClientManager clientManager, TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void doGreatThings(Request request, AsyncMethodCallback<doGreatThings_call> __resultHandler__) throws TException {
      checkReady();
      doGreatThings_call __method_call__ = new doGreatThings_call(request, __resultHandler__, this, super.protocolFactory, super.transport);
      manager.call(__method_call__);
    }

    public static class doGreatThings_call extends TAsyncMethodCall<doGreatThings_call> {
      private Request request;

      public doGreatThings_call(Request request, AsyncMethodCallback<doGreatThings_call> __resultHandler__, TAsyncClient __client__, TProtocolFactory __protocolFactory__, TNonblockingTransport __transport__) throws TException {
        super(__client__, __protocolFactory__, __transport__, __resultHandler__, false);
        this.request = request;
      }

      public void write_args(TProtocol __prot__) throws TException {
        __prot__.writeMessageBegin(new TMessage("doGreatThings", TMessageType.CALL, 0));
        doGreatThings_args __args__ = new doGreatThings_args();
        __args__.setRequest(request);
        __args__.write(__prot__);
        __prot__.writeMessageEnd();
      }

      public Response getResult() throws OverCapacityException, TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        TMemoryInputTransport __memoryTransport__ = new TMemoryInputTransport(getFrameBuffer().array());
        TProtocol __prot__ = super.client.getProtocolFactory().getProtocol(__memoryTransport__);
        return (new Client(__prot__)).recv_doGreatThings();
      }
     }
   }


  public static class ServiceToClient implements ServiceIface {
    private final com.twitter.finagle.Service<ThriftClientRequest, byte[]> service;
    private final TProtocolFactory protocolFactory;
    private final TReusableBuffer tlReusableBuffer;
    private final scala.PartialFunction<com.twitter.finagle.service.ReqRep,com.twitter.finagle.service.ResponseClass> responseClassifier;

    /**
     * @deprecated use {@link com.twitter.finagle.thrift.RichClientParam} instead
     */
    @Deprecated
    public ServiceToClient(com.twitter.finagle.Service<ThriftClientRequest, byte[]> service, TProtocolFactory protocolFactory, scala.PartialFunction<com.twitter.finagle.service.ReqRep,com.twitter.finagle.service.ResponseClass> responseClassifier) {
      this(service, new com.twitter.finagle.thrift.RichClientParam(protocolFactory, responseClassifier));
    }

    public ServiceToClient(com.twitter.finagle.Service<ThriftClientRequest, byte[]> service, com.twitter.finagle.thrift.RichClientParam clientParam) {

      this.service = service;
      this.protocolFactory = clientParam.protocolFactory();
      this.responseClassifier = clientParam.responseClassifier();
      this.tlReusableBuffer = new TReusableBuffer(512, clientParam.maxThriftBufferSize());
    }

    public ServiceToClient(com.twitter.finagle.Service<ThriftClientRequest, byte[]> service) {
      this(service, new com.twitter.finagle.thrift.RichClientParam());
    }

    /**
     * @deprecated use {@link com.twitter.finagle.thrift.RichClientParam} instead
     */
    @Deprecated
    public ServiceToClient(com.twitter.finagle.Service<ThriftClientRequest, byte[]> service, TProtocolFactory protocolFactory) {
      this(service, new com.twitter.finagle.thrift.RichClientParam(protocolFactory, com.twitter.finagle.service.ResponseClassifier.Default()));
    }

    public Future<Response> doGreatThings(Request request) {
      try {
        TReusableMemoryTransport __memoryTransport__ = tlReusableBuffer.get();
        TProtocol __prot__ = this.protocolFactory.getProtocol(__memoryTransport__);
        __prot__.writeMessageBegin(new TMessage("doGreatThings", TMessageType.CALL, 0));
        doGreatThings_args __args__ = new doGreatThings_args();
        __args__.setRequest(request);
        __args__.write(__prot__);
        __prot__.writeMessageEnd();


        byte[] __buffer__ = Arrays.copyOfRange(__memoryTransport__.getArray(), 0, __memoryTransport__.length());
        final ThriftClientRequest __request__ = new ThriftClientRequest(__buffer__, false);

        Function<byte[], com.twitter.util.Try<Response>> replyDeserializer =
          new Function<byte[], com.twitter.util.Try<Response>>() {
            public com.twitter.util.Try<Response> apply(byte[] __buffer__) {
              TMemoryInputTransport __memoryTransport__ = new TMemoryInputTransport(__buffer__);
              TProtocol __prot__ = ServiceToClient.this.protocolFactory.getProtocol(__memoryTransport__);
              try {
                return new com.twitter.util.Return<Response>(((new Client(__prot__)).recv_doGreatThings()));
              } catch (Exception e) {
                return new com.twitter.util.Throw<Response>(e);
              }
            }
          };
        DeserializeCtx serdeCtx = new DeserializeCtx<Response>(__args__, replyDeserializer);

        return com.twitter.finagle.context.Contexts.local().let(
          DeserializeCtx.Key(),
          serdeCtx,
          new com.twitter.util.Function0<Future<Response>>() {
            public Future<Response> apply() {

              Future<byte[]> __done__ = service.apply(__request__);
              return __done__.flatMap(new Function<byte[], Future<Response>>() {
                public Future<Response> apply(byte[] __buffer__) {
                  TMemoryInputTransport __memoryTransport__ = new TMemoryInputTransport(__buffer__);
                  TProtocol __prot__ = ServiceToClient.this.protocolFactory.getProtocol(__memoryTransport__);
                  try {
                    return Future.value((new Client(__prot__)).recv_doGreatThings());
                  } catch (Exception e) {
                    return Future.exception(e);
                  }
                }
              });
            }
          });
      } catch (TException e) {
        return Future.exception(e);
      } finally {
        tlReusableBuffer.reset();
      }
    }
  }

  public static class Processor implements TProcessor {
    public Processor(Iface iface)
    {
      iface_ = iface;
      processMap_.put("doGreatThings", new doGreatThings());
    }

    protected static interface ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException;
    }

    private Iface iface_;
    protected final HashMap<String,ProcessFunction> processMap_ = new HashMap<String,ProcessFunction>();

    public boolean process(TProtocol iprot, TProtocol oprot) throws TException
    {
      TMessage msg = iprot.readMessageBegin();
      ProcessFunction fn = processMap_.get(msg.name);
      if (fn == null) {
        TProtocolUtil.skip(iprot, TType.STRUCT);
        iprot.readMessageEnd();
        TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
        oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        return true;
      }
      fn.process(msg.seqid, iprot, oprot);
      return true;
    }

    private class doGreatThings implements ProcessFunction {
      public void process(int seqid, TProtocol iprot, TProtocol oprot) throws TException
      {
        doGreatThings_args args = new doGreatThings_args();
        try {
          args.read(iprot);
        } catch (TProtocolException e) {
          iprot.readMessageEnd();
          TApplicationException x = new TApplicationException(TApplicationException.PROTOCOL_ERROR, e.getMessage());
          oprot.writeMessageBegin(new TMessage("doGreatThings", TMessageType.EXCEPTION, seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return;
        }
        iprot.readMessageEnd();
        doGreatThings_result result = new doGreatThings_result();
        try {
          result.success = iface_.doGreatThings(args.request);

        } catch (OverCapacityException ex) {
          result.ex = ex;
        } catch (Throwable th) {
          TApplicationException x = new TApplicationException(TApplicationException.INTERNAL_ERROR, "Internal error processing doGreatThings");
          oprot.writeMessageBegin(new TMessage("doGreatThings", TMessageType.EXCEPTION, seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return;
        }
        oprot.writeMessageBegin(new TMessage("doGreatThings", TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
      }
    }
  }

  public static class Service extends com.twitter.finagle.Service<byte[], byte[]> {
    private final ServiceIface iface;
    private final TProtocolFactory protocolFactory;
    private final TReusableBuffer tlReusableBuffer;
    protected HashMap<String, com.twitter.finagle.Service<scala.Tuple2<TProtocol, Integer>, byte[]>> serviceMap =
      new HashMap<String, com.twitter.finagle.Service<scala.Tuple2<TProtocol, Integer>, byte[]>>();
    public Service(final ServiceIface iface, final com.twitter.finagle.thrift.RichServerParam serverParam) {
      this.iface = iface;
      this.protocolFactory = serverParam.protocolFactory();
      this.tlReusableBuffer = new TReusableBuffer(512, serverParam.maxThriftBufferSize());
      createMethods();
    }

    public Service(final ServiceIface iface) {
      this(iface, new com.twitter.finagle.thrift.RichServerParam());
    }

    /**
     * @deprecated use {@link com.twitter.finagle.thrift.RichServerParam} instead
     */
    @Deprecated
    public Service(final ServiceIface iface, final TProtocolFactory protocolFactory) {
      this(iface, new com.twitter.finagle.thrift.RichServerParam(protocolFactory));
    }

    private void createMethods() {

      class doGreatThingsService {
        private final com.twitter.finagle.SimpleFilter<scala.Tuple2<TProtocol, Integer>, byte[]> protocolExnFilter = new com.twitter.finagle.SimpleFilter<scala.Tuple2<TProtocol, Integer>, byte[]>() {
          @Override
          public Future<byte[]> apply(scala.Tuple2<TProtocol, Integer> request, com.twitter.finagle.Service<scala.Tuple2<TProtocol, Integer>, byte[]> service) {
            return service.apply(request).rescue(new Function<Throwable, Future<byte[]>>() {
              @Override
              public Future<byte[]> apply(Throwable e) {
                TProtocol iprot = request._1();
                Integer seqid = request._2();
                if (e instanceof TProtocolException) {
                  try {
                    iprot.readMessageEnd();
                    return exception("doGreatThings", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage());
                  } catch (Exception e1) {
                    return Future.exception(e1);
                  }
                } else {
                  return Future.exception(e);
                }
              }
            });
          }
        };

        private final com.twitter.finagle.Filter<scala.Tuple2<TProtocol, Integer>, byte[], doGreatThings_args, Response> serdeFilter = new com.twitter.finagle.Filter<scala.Tuple2<TProtocol, Integer>, byte[], doGreatThings_args, Response>() {
          @Override
          public Future<byte[]> apply(scala.Tuple2<TProtocol, Integer> request, com.twitter.finagle.Service<doGreatThings_args, Response> service) {
            TProtocol iprot = request._1();
            Integer seqid = request._2();
            doGreatThings_args args = new doGreatThings_args();
            try {
              args.read(iprot);
              iprot.readMessageEnd();
            } catch (Exception e) {
              return Future.exception(e);
            }

            Future<Response> res = service.apply(args);
            doGreatThings_result result = new doGreatThings_result();
            return res.flatMap(new Function<Response, Future<byte[]>>() {
              @Override
              public Future<byte[]> apply(Response value) {
                result.success = value;
                result.setSuccessIsSet(true);
                return reply("doGreatThings", seqid, result);
              }
            }).rescue(new Function<Throwable, Future<byte[]>>() {
              @Override
              public Future<byte[]> apply(Throwable t) {
                if (t instanceof OverCapacityException) {
                  result.ex = (OverCapacityException)t;
                  return reply("doGreatThings", seqid, result);
                }
                else {
                  return Future.exception(t);
                }
              }
            });
          }
        };

        private final com.twitter.finagle.Service<doGreatThings_args, Response> methodService = new com.twitter.finagle.Service<doGreatThings_args, Response>() {
          @Override
          public Future<Response> apply(doGreatThings_args args) {
            Future<Response> future;
            try {
              future = iface.doGreatThings(args.request);
            } catch (Exception e) {
              future = Future.exception(e);
            }
            return future;
          }
        };

        private final com.twitter.finagle.Service<scala.Tuple2<TProtocol, Integer>, byte[]> getService =
          protocolExnFilter.andThen(serdeFilter).andThen(methodService);
      }

      serviceMap.put("doGreatThings", (new doGreatThingsService()).getService);
    }

    public Future<byte[]> apply(byte[] request) {
      TTransport inputTransport = new TMemoryInputTransport(request);
      TProtocol iprot = protocolFactory.getProtocol(inputTransport);

      TMessage msg;
      try {
        msg = iprot.readMessageBegin();
      } catch (Exception e) {
        return Future.exception(e);
      }

      com.twitter.finagle.Service<scala.Tuple2<TProtocol, Integer>, byte[]> svc = serviceMap.get(msg.name);
      if (svc == null) {
        try {
          TProtocolUtil.skip(iprot, TType.STRUCT);
          iprot.readMessageEnd();
          TApplicationException x = new TApplicationException(TApplicationException.UNKNOWN_METHOD, "Invalid method name: '"+msg.name+"'");
          TReusableMemoryTransport memoryBuffer = tlReusableBuffer.get();
          TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);
          oprot.writeMessageBegin(new TMessage(msg.name, TMessageType.EXCEPTION, msg.seqid));
          x.write(oprot);
          oprot.writeMessageEnd();
          oprot.getTransport().flush();
          return Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()));
        } catch (Exception e) {
          return Future.exception(e);
        } finally {
          tlReusableBuffer.reset();
        }
      }

      return svc.apply(new scala.Tuple2(iprot, msg.seqid));
    }

    private Future<byte[]> reply(String name, Integer seqid, TBase result) {
      try {
        TReusableMemoryTransport memoryBuffer = tlReusableBuffer.get();
        TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);

        oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid));
        result.write(oprot);
        oprot.writeMessageEnd();

        return Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()));
      } catch (Exception e) {
        return Future.exception(e);
      } finally {
        tlReusableBuffer.reset();
      }
    }

    private Future<byte[]> exception(String name, Integer seqid, Integer code, String message) {
      try {
        TApplicationException x = new TApplicationException(code, message);
        TReusableMemoryTransport memoryBuffer = tlReusableBuffer.get();
        TProtocol oprot = protocolFactory.getProtocol(memoryBuffer);

        oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid));
        x.write(oprot);
        oprot.writeMessageEnd();
        oprot.getTransport().flush();
        byte[] buffer = Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length());
        return Future.value(buffer);
      } catch (Exception e1) {
        return Future.exception(e1);
      } finally {
        tlReusableBuffer.reset();
      }
    }
  }

  public static class doGreatThings_args implements TBase<doGreatThings_args, doGreatThings_args._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("doGreatThings_args");

  private static final TField REQUEST_FIELD_DESC = new TField("request", TType.STRUCT, (short)1);


  public Request request;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    REQUEST((short)1, "request");

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
        case 1: // REQUEST
          return REQUEST;
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


  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.REQUEST, new FieldMetaData("request", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, Request.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(doGreatThings_args.class, metaDataMap);
  }


  public doGreatThings_args() {
  }

  public doGreatThings_args(
    Request request)
  {
    this();
    this.request = request;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public doGreatThings_args(doGreatThings_args other) {
    if (other.isSetRequest()) {
      this.request = new Request(other.request);
    }
  }

  public doGreatThings_args deepCopy() {
    return new doGreatThings_args(this);
  }

  @java.lang.Override
  public void clear() {
    this.request = null;
  }

  public Request getRequest() {
    return this.request;
  }

  public doGreatThings_args setRequest(Request request) {
    this.request = request;

    return this;
  }

  public void unsetRequest() {
    this.request = null;
  }

  /** Returns true if field request is set (has been asigned a value) and false otherwise */
  public boolean isSetRequest() {
    return this.request != null;
  }

  public void setRequestIsSet(boolean value) {
    if (!value) {
      this.request = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case REQUEST:
      if (value == null) {
        unsetRequest();
      } else {
        setRequest((Request)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case REQUEST:
      return getRequest();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case REQUEST:
      return isSetRequest();
    }
    throw new IllegalStateException();
  }

  @java.lang.Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof doGreatThings_args)
      return this.equals((doGreatThings_args)that);
    return false;
  }

  public boolean equals(doGreatThings_args that) {
    if (that == null)
      return false;
    boolean this_present_request = true && this.isSetRequest();
    boolean that_present_request = true && that.isSetRequest();
    if (this_present_request || that_present_request) {
      if (!(this_present_request && that_present_request))
        return false;
      if (!this.request.equals(that.request))
        return false;
    }

    return true;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_request = true && (isSetRequest());
    builder.append(present_request);
    if (present_request)
      builder.append(request);
    return builder.toHashCode();
  }

  public int compareTo(doGreatThings_args other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    doGreatThings_args typedOther = (doGreatThings_args)other;

    lastComparison = Boolean.valueOf(isSetRequest()).compareTo(typedOther.isSetRequest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRequest()) {
      lastComparison = TBaseHelper.compareTo(this.request, typedOther.request);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 1: // REQUEST
          if (field.type == TType.STRUCT) {
            this.request = new Request();
            this.request.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.request != null) {
      oprot.writeFieldBegin(REQUEST_FIELD_DESC);
      this.request.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @java.lang.Override
  public String toString() {
    StringBuilder sb = new StringBuilder("doGreatThings_args(");
    boolean first = true;
    sb.append("request:");
    if (this.request == null) {
      sb.append("null");
    } else {
      sb.append(this.request);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}


  public static class doGreatThings_result implements TBase<doGreatThings_result, doGreatThings_result._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("doGreatThings_result");

  private static final TField SUCCESS_FIELD_DESC = new TField("success", TType.STRUCT, (short)0);
  private static final TField EX_FIELD_DESC = new TField("ex", TType.STRUCT, (short)1);


  public Response success;
  public OverCapacityException ex;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    SUCCESS((short)0, "success"),
    EX((short)1, "ex");

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
        case 0: // SUCCESS
          return SUCCESS;
        case 1: // EX
          return EX;
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


  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUCCESS, new FieldMetaData("success", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, Response.class)));
    tmpMap.put(_Fields.EX, new FieldMetaData("ex", TFieldRequirementType.DEFAULT,
      new StructMetaData(TType.STRUCT, OverCapacityException.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(doGreatThings_result.class, metaDataMap);
  }


  public doGreatThings_result() {
  }

  public doGreatThings_result(
    Response success,
    OverCapacityException ex)
  {
    this();
    this.success = success;
    this.ex = ex;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public doGreatThings_result(doGreatThings_result other) {
    if (other.isSetSuccess()) {
      this.success = new Response(other.success);
    }
    if (other.isSetEx()) {
      this.ex = new OverCapacityException(other.ex);
    }
  }

  public doGreatThings_result deepCopy() {
    return new doGreatThings_result(this);
  }

  @java.lang.Override
  public void clear() {
    this.success = null;
    this.ex = null;
  }

  public Response getSuccess() {
    return this.success;
  }

  public doGreatThings_result setSuccess(Response success) {
    this.success = success;

    return this;
  }

  public void unsetSuccess() {
    this.success = null;
  }

  /** Returns true if field success is set (has been asigned a value) and false otherwise */
  public boolean isSetSuccess() {
    return this.success != null;
  }

  public void setSuccessIsSet(boolean value) {
    if (!value) {
      this.success = null;
    }
  }

  public OverCapacityException getEx() {
    return this.ex;
  }

  public doGreatThings_result setEx(OverCapacityException ex) {
    this.ex = ex;

    return this;
  }

  public void unsetEx() {
    this.ex = null;
  }

  /** Returns true if field ex is set (has been asigned a value) and false otherwise */
  public boolean isSetEx() {
    return this.ex != null;
  }

  public void setExIsSet(boolean value) {
    if (!value) {
      this.ex = null;
    }
  }

  @SuppressWarnings("unchecked")
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SUCCESS:
      if (value == null) {
        unsetSuccess();
      } else {
        setSuccess((Response)value);
      }
      break;
    case EX:
      if (value == null) {
        unsetEx();
      } else {
        setEx((OverCapacityException)value);
      }
      break;
    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SUCCESS:
      return getSuccess();
    case EX:
      return getEx();
    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SUCCESS:
      return isSetSuccess();
    case EX:
      return isSetEx();
    }
    throw new IllegalStateException();
  }

  @java.lang.Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof doGreatThings_result)
      return this.equals((doGreatThings_result)that);
    return false;
  }

  public boolean equals(doGreatThings_result that) {
    if (that == null)
      return false;
    boolean this_present_success = true && this.isSetSuccess();
    boolean that_present_success = true && that.isSetSuccess();
    if (this_present_success || that_present_success) {
      if (!(this_present_success && that_present_success))
        return false;
      if (!this.success.equals(that.success))
        return false;
    }
    boolean this_present_ex = true && this.isSetEx();
    boolean that_present_ex = true && that.isSetEx();
    if (this_present_ex || that_present_ex) {
      if (!(this_present_ex && that_present_ex))
        return false;
      if (!this.ex.equals(that.ex))
        return false;
    }

    return true;
  }

  @java.lang.Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();
    boolean present_success = true && (isSetSuccess());
    builder.append(present_success);
    if (present_success)
      builder.append(success);
    boolean present_ex = true && (isSetEx());
    builder.append(present_ex);
    if (present_ex)
      builder.append(ex);
    return builder.toHashCode();
  }

  public int compareTo(doGreatThings_result other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    doGreatThings_result typedOther = (doGreatThings_result)other;

    lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSuccess()) {
      lastComparison = TBaseHelper.compareTo(this.success, typedOther.success);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetEx()).compareTo(typedOther.isSetEx());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEx()) {
      lastComparison = TBaseHelper.compareTo(this.ex, typedOther.ex);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 0: // SUCCESS
          if (field.type == TType.STRUCT) {
            this.success = new Response();
            this.success.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 1: // EX
          if (field.type == TType.STRUCT) {
            this.ex = new OverCapacityException();
            this.ex.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.isSetSuccess()) {
      oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
      this.success.write(oprot);
      oprot.writeFieldEnd();
    } else if (this.isSetEx()) {
      oprot.writeFieldBegin(EX_FIELD_DESC);
      this.ex.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @java.lang.Override
  public String toString() {
    StringBuilder sb = new StringBuilder("doGreatThings_result(");
    boolean first = true;
    sb.append("success:");
    if (this.success == null) {
      sb.append("null");
    } else {
      sb.append(this.success);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ex:");
    if (this.ex == null) {
      sb.append("null");
    } else {
      sb.append(this.ex);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }
}



}

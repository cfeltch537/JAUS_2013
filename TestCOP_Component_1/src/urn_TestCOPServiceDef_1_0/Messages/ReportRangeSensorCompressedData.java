package src.urn_TestCOPServiceDef_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportRangeSensorCompressedData extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4804;
	
	public static class  AppHeader
	{
		public static class  HeaderRec
		{
		
			protected AppHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(AppHeader parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public int getMessageID()
			{
				return m_MessageID;
			}
			
			public void setMessageID(int value)
			{
				m_MessageID = value;
				setParentPresenceVector();
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				bytes.putShort(pos, (short) m_MessageID);
				pos += JausUtils.getNumBytes("short");
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				m_MessageID = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
			}
			
			public ReportRangeSensorCompressedData.AppHeader.HeaderRec assign(HeaderRec value)
			{
				m_MessageID = value.m_MessageID;
				
				return this;
			}
			
			public boolean isEqual(HeaderRec value)
			{
				if (m_MessageID != value.getMessageID())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(HeaderRec value)
			{
				return !this.isEqual(value);
			}
			
			public HeaderRec()
			{
				m_parent = null;
				m_MessageID = 0x4804;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4804;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportRangeSensorCompressedData.AppHeader.HeaderRec getHeaderRec()
		{
			return m_HeaderRec;
		}
		
		public void setHeaderRec(HeaderRec value)
		{
			m_HeaderRec = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_HeaderRec.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.encode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_HeaderRec.decode(bytes, pos);
			pos += m_HeaderRec.getSize();
		}
		
		public ReportRangeSensorCompressedData.AppHeader assign(AppHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(AppHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(AppHeader value)
		{
			return !this.isEqual(value);
		}
		
		public AppHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public AppHeader(AppHeader value)
		{
			/// Initiliaze the protected variables
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
			
			/// Copy the values
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
		}
		
		public void finalize()
		{
		}
		
	}
	public static class  Body
	{
		public static class  RangeSensorCompressedDataList
		{
			public static class  RangeSensorCompressedDataVariant
			{
				public static class  RangeSensorDataErrorRec
				{
				
					protected RangeSensorCompressedDataVariant m_parent;
					protected int m_SensorID;
					protected short m_DataErrorCode;
					protected String m_ErrorMessage;
				
					public void setParent(RangeSensorCompressedDataVariant parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setParentPresenceVector();
						}
					}
					
					public int getSensorID()
					{
						return m_SensorID;
					}
					
					public void setSensorID(int value)
					{
						m_SensorID = value;
						setParentPresenceVector();
					}
					
					public short getDataErrorCode()
					{
						return m_DataErrorCode;
					}
					
					public void setDataErrorCode(short value)
					{
						if ((value == 0) || (value == 1) || (value == 255))
						{
							m_DataErrorCode = value;
							setParentPresenceVector();
						}
						return;
					}
					
					public String getErrorMessage()
					{
						return m_ErrorMessage;
					}
					
					public void setErrorMessage(String value)
					{
						if ( value.length() > 255)
						{
							return;
						}
						
						m_ErrorMessage = value;
						if (m_ErrorMessage.length() < 0)
						{
							m_ErrorMessage = m_ErrorMessage.substring(0, 0);
						}
						setParentPresenceVector();
					}
					
					/**
					 * Returns the number of bytes the used data members of the class occupies
					 * in the buffer. This is not the number of bytes the data type occupies in 
					 * Java, but the bytes expected on the wire.
					 * 
					 * @return
					 */
					public long getSize()
					{
						long size = 0;
						
						size += JausUtils.getNumBytes("short");
						size += JausUtils.getNumBytes("byte");
						size += JausUtils.getNumBytes("byte");
						size += m_ErrorMessage.length();
						
						return size;
					}
					
					public void encode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						bytes.putShort(pos, (short) m_SensorID);
						pos += JausUtils.getNumBytes("short");
						bytes.put(pos, (byte) m_DataErrorCode);
						pos += JausUtils.getNumBytes("byte");
						
						try
						{
						bytes.put(pos, (byte) m_ErrorMessage.length());
						pos += JausUtils.getNumBytes("byte");
						
						char[] m_ErrorMessageBytes = m_ErrorMessage.toCharArray();
						for(int str_pos = 0; str_pos<m_ErrorMessageBytes.length; str_pos++)
						{
							bytes.put(pos, (byte) m_ErrorMessageBytes[str_pos]);
							pos++;
						}
						}
						catch (Exception e)
						{
							
						}
					}
					
					public void decode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						m_SensorID = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
						m_DataErrorCode = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						
						short m_ErrorMessageLength = 0;
						m_ErrorMessageLength = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						
						
						// Decoding the string m_ErrorMessagefrom the buffer.
						char[] m_ErrorMessageBytes = new char[(int)m_ErrorMessageLength];
						for(int decode_pos = 0; decode_pos<(int)m_ErrorMessageLength;decode_pos++)
						{
							m_ErrorMessageBytes[decode_pos] = (char) (bytes.get(pos) &0xff);
							pos++;
						}
						m_ErrorMessage = new String(m_ErrorMessageBytes);
					}
					
					public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorDataErrorRec assign(RangeSensorDataErrorRec value)
					{
						m_SensorID = value.m_SensorID;
						m_DataErrorCode = value.m_DataErrorCode;
						m_ErrorMessage = value.m_ErrorMessage;
						
						return this;
					}
					
					public boolean isEqual(RangeSensorDataErrorRec value)
					{
						if (m_SensorID != value.getSensorID())
						{
							return false;
						}
						if (m_DataErrorCode != value.getDataErrorCode())
						{
							return false;
						}
						if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(RangeSensorDataErrorRec value)
					{
						return !this.isEqual(value);
					}
					
					public RangeSensorDataErrorRec()
					{
						m_parent = null;
						m_SensorID = 0;
						m_DataErrorCode = 0;
						m_ErrorMessage = new String();
					}
					
					public RangeSensorDataErrorRec(RangeSensorDataErrorRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SensorID = 0;
						m_DataErrorCode = 0;
						m_ErrorMessage = new String();
						
						/// Copy the values
						m_SensorID = value.m_SensorID;
						m_DataErrorCode = value.m_DataErrorCode;
						m_ErrorMessage = value.m_ErrorMessage;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  RangeSensorCompressedDataRec
				{
					public static class  TimeStamp
					{
					
						protected RangeSensorCompressedDataRec m_parent;
						protected long m_SubFields;
					
						public void setParent(RangeSensorCompressedDataRec parent)
						{
							m_parent = parent;
						}
						
						public void setParentPresenceVector()
						{
							if(m_parent != null )
							{
								m_parent.setParentPresenceVector();
							}
						}
						
						public long getMilliseconds()
						{
							BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
							BitSet subFieldBitSet = new BitSet(10);
							int i = 0;
							
							for (int index = 0; index <= 9; index++)
							{
							    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
							}
							
							return (long)JausUtils.getPVLong(subFieldBitSet);
						}
						
						public int setMilliseconds(long value)
						{
							if (((value >= 0) && (value <= 999)))
							{
								BitSet bfbs = JausUtils.setPV(m_SubFields);
								BitSet sfbs = new BitSet(10);
								sfbs = JausUtils.setPV(value);
								int i = 0;
								
								for (int index = 0; index <= 9; index++)
								{
									bfbs.set(index, sfbs.get(i++));
								}
								
								m_SubFields = (long) JausUtils.getPVLong(bfbs);
								setParentPresenceVector();
								return 0;
							}
							return 1;
						}
						
						public long getSeconds()
						{
							BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
							BitSet subFieldBitSet = new BitSet(6);
							int i = 0;
							
							for (int index = 10; index <= 15; index++)
							{
							    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
							}
							
							return (long)JausUtils.getPVLong(subFieldBitSet);
						}
						
						public int setSeconds(long value)
						{
							if (((value >= 0) && (value <= 59)))
							{
								BitSet bfbs = JausUtils.setPV(m_SubFields);
								BitSet sfbs = new BitSet(6);
								sfbs = JausUtils.setPV(value);
								int i = 0;
								
								for (int index = 10; index <= 15; index++)
								{
									bfbs.set(index, sfbs.get(i++));
								}
								
								m_SubFields = (long) JausUtils.getPVLong(bfbs);
								setParentPresenceVector();
								return 0;
							}
							return 1;
						}
						
						public long getMinutes()
						{
							BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
							BitSet subFieldBitSet = new BitSet(6);
							int i = 0;
							
							for (int index = 16; index <= 21; index++)
							{
							    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
							}
							
							return (long)JausUtils.getPVLong(subFieldBitSet);
						}
						
						public int setMinutes(long value)
						{
							if (((value >= 0) && (value <= 59)))
							{
								BitSet bfbs = JausUtils.setPV(m_SubFields);
								BitSet sfbs = new BitSet(6);
								sfbs = JausUtils.setPV(value);
								int i = 0;
								
								for (int index = 16; index <= 21; index++)
								{
									bfbs.set(index, sfbs.get(i++));
								}
								
								m_SubFields = (long) JausUtils.getPVLong(bfbs);
								setParentPresenceVector();
								return 0;
							}
							return 1;
						}
						
						public long getHour()
						{
							BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
							BitSet subFieldBitSet = new BitSet(5);
							int i = 0;
							
							for (int index = 22; index <= 26; index++)
							{
							    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
							}
							
							return (long)JausUtils.getPVLong(subFieldBitSet);
						}
						
						public int setHour(long value)
						{
							if (((value >= 0) && (value <= 23)))
							{
								BitSet bfbs = JausUtils.setPV(m_SubFields);
								BitSet sfbs = new BitSet(5);
								sfbs = JausUtils.setPV(value);
								int i = 0;
								
								for (int index = 22; index <= 26; index++)
								{
									bfbs.set(index, sfbs.get(i++));
								}
								
								m_SubFields = (long) JausUtils.getPVLong(bfbs);
								setParentPresenceVector();
								return 0;
							}
							return 1;
						}
						
						public long getDay()
						{
							BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
							BitSet subFieldBitSet = new BitSet(5);
							int i = 0;
							
							for (int index = 27; index <= 31; index++)
							{
							    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
							}
							
							return (long)JausUtils.getPVLong(subFieldBitSet);
						}
						
						public int setDay(long value)
						{
							if (((value >= 1) && (value <= 31)))
							{
								BitSet bfbs = JausUtils.setPV(m_SubFields);
								BitSet sfbs = new BitSet(5);
								sfbs = JausUtils.setPV(value);
								int i = 0;
								
								for (int index = 27; index <= 31; index++)
								{
									bfbs.set(index, sfbs.get(i++));
								}
								
								m_SubFields = (long) JausUtils.getPVLong(bfbs);
								setParentPresenceVector();
								return 0;
							}
							return 1;
						}
						
						/**
						 * Returns the number of bytes the used data members of the class occupies
						 * in the buffer. This is not the number of bytes the data type occupies in 
						 * Java, but the bytes expected on the wire.
						 * 
						 * @return
						 */
						public long getSize()
						{
							long size = 0;
							
							size += JausUtils.getNumBytes("int");
							
							return size;
						}
						
						public void encode(ByteBuffer bytes, int pos)
						{
							
							if (bytes.array() == null)
							{
								return;
							}
							
							if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
							{
								bytes.order(ByteOrder.LITTLE_ENDIAN);
							}
							
							
							bytes.putInt(pos, (int) m_SubFields);
							pos += JausUtils.getNumBytes("int");
						}
						
						public void decode(ByteBuffer bytes, int pos)
						{
							
							if (bytes.array() == null)
							{
								return;
							}
							if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
							{
								bytes.order(ByteOrder.LITTLE_ENDIAN);
							}
							
							m_SubFields = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
						}
						
						public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec.TimeStamp assign(TimeStamp value)
						{
							this.m_SubFields = value.m_SubFields;
							
							return this;
						}
						
						public boolean isEqual(TimeStamp value)
						{
							return this.m_SubFields == value.getDay();
						}
						
						public boolean notEquals(TimeStamp value)
						{
							return !this.isEqual(value);
						}
						
						public TimeStamp()
						{
							m_parent = null;
							m_SubFields = 0;
						}
						
						public TimeStamp(TimeStamp value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SubFields = 0;
							
							/// Copy the values
							this.m_SubFields = value.m_SubFields;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  CompressedData
					{
					
						protected RangeSensorCompressedDataRec m_parent;
						protected long m_Length;
						protected ByteBuffer m_Data;
					
						public void setParent(RangeSensorCompressedDataRec parent)
						{
							m_parent = parent;
						}
						
						public void setParentPresenceVector()
						{
							if(m_parent != null )
							{
								m_parent.setParentPresenceVector();
							}
						}
						
						public long getLength()
						{
							return m_Length;
						}
						
						public ByteBuffer getData()
						{
							m_Data.rewind();
							ByteBuffer ret = ByteBuffer.allocate(m_Data.array().length);
							ret.order(ByteOrder.LITTLE_ENDIAN);
							ret.put(m_Data);
							return ret;
						}
						
						public void set(long length, ByteBuffer data)
						{
							m_Length = length;
							
							m_Data.clear();
							
							if (m_Length > 0)
							{
								data.rewind();
								m_Data = ByteBuffer.allocate(data.array().length);
								m_Data.order(ByteOrder.LITTLE_ENDIAN);
								m_Data.put(data);
							}
							
							setParentPresenceVector();
						}
						
						/**
						 * Returns the number of bytes the used data members of the class occupies
						 * in the buffer. This is not the number of bytes the data type occupies in 
						 * Java, but the bytes expected on the wire.
						 * 
						 * @return
						 */
						public long getSize()
						{
							long size = 0;
							
							size += JausUtils.getNumBytes("int");
							size += m_Length;
							
							return size;
						}
						
						public void encode(ByteBuffer bytes, int pos)
						{
							
							if (bytes.array() == null)
							{
								return;
							}
							
							if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
							{
								bytes.order(ByteOrder.LITTLE_ENDIAN);
							}
							
							
							bytes.putInt(pos, (int) m_Length);
							pos += JausUtils.getNumBytes("int");
							
							byte[] byteArray = m_Data.array();
							
							for(int i = 0; i<(int) m_Length; i++)
							{
								bytes.put(pos, byteArray[i]);
								pos++;
							}
							
						}
						
						public void decode(ByteBuffer bytes, int pos)
						{
							
							if (bytes.array() == null)
							{
								return;
							}
							if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
							{
								bytes.order(ByteOrder.LITTLE_ENDIAN);
							}
							
							
							m_Length = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
							byte[] byteArray = new byte[(int)m_Length];
							
							int i;
							for(i=0; i<(int) m_Length; i++)
							{
								byteArray[i] = bytes.get(pos);
								pos++;
							}
							
							m_Data = ByteBuffer.allocate((int)m_Length).order(ByteOrder.LITTLE_ENDIAN);
							m_Data.put(byteArray);
						}
						
						public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec.CompressedData assign(CompressedData value)
						{
							this.m_Length = value.m_Length;
							
							m_Data.clear();
							
							if (m_Length > 0)
							{
								this.m_Data.put(value.m_Data);
							}
							
							return this;
						}
						
						public boolean isEqual(CompressedData value)
						{
							if (this.m_Length != value.getLength())
							{
								return false;
							}
							
							if ((this.m_Data != null) && (value.m_Data!= null))
							{
								if(!Arrays.equals(this.m_Data.array(), value.m_Data.array()))
								{
									return false;
								}
							}
							// This case should never be true since it should not be possible
							// for the two variables to have equal lengths but one has no data.
							// This check is placed here as a secondary check.
							else if ((this.m_Data != null) || (value.m_Data != null))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(CompressedData value)
						{
							return !this.isEqual(value);
						}
						
						public CompressedData()
						{
							m_parent = null;
							m_Length = MAX_JTS_MESSAGE_SIZE;
							m_Data = ByteBuffer.allocate((int)m_Length);
							m_Data.order(ByteOrder.LITTLE_ENDIAN); 
						}
						
						public CompressedData(CompressedData value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_Length = MAX_JTS_MESSAGE_SIZE;
							m_Data = ByteBuffer.allocate((int)m_Length);
							m_Data.order(ByteOrder.LITTLE_ENDIAN); 
							
							/// Copy the values
							this.m_Length = value.m_Length;
							
							m_Data.clear();
							
							if (m_Length > 0)
							{
								this.m_Data.put(value.m_Data);
							}
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected RangeSensorCompressedDataVariant m_parent;
					protected int m_SensorID;
					protected short m_ReportCoordinateSystem;
					protected TimeStamp m_TimeStamp;
					protected short m_DataCompression;
					protected CompressedData m_CompressedData;
				
					public void setParent(RangeSensorCompressedDataVariant parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setParentPresenceVector();
						}
					}
					
					public int getSensorID()
					{
						return m_SensorID;
					}
					
					public void setSensorID(int value)
					{
						m_SensorID = value;
						setParentPresenceVector();
					}
					
					public short getReportCoordinateSystem()
					{
						return m_ReportCoordinateSystem;
					}
					
					public void setReportCoordinateSystem(short value)
					{
						if ((value == 0) || (value == 1))
						{
							m_ReportCoordinateSystem = value;
							setParentPresenceVector();
						}
						return;
					}
					
					public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec.TimeStamp getTimeStamp()
					{
						return m_TimeStamp;
					}
					
					public void setTimeStamp(TimeStamp value)
					{
						m_TimeStamp = value;
						setParentPresenceVector();
					}
					
					public short getDataCompression()
					{
						return m_DataCompression;
					}
					
					public void setDataCompression(short value)
					{
						if ((value == 0) || (value == 1) || (value == 2) || (value == 3))
						{
							m_DataCompression = value;
							setParentPresenceVector();
						}
						return;
					}
					
					public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec.CompressedData getCompressedData()
					{
						return m_CompressedData;
					}
					
					public void setCompressedData(CompressedData value)
					{
						m_CompressedData = value;
						setParentPresenceVector();
					}
					
					/**
					 * Returns the number of bytes the used data members of the class occupies
					 * in the buffer. This is not the number of bytes the data type occupies in 
					 * Java, but the bytes expected on the wire.
					 * 
					 * @return
					 */
					public long getSize()
					{
						long size = 0;
						
						size += JausUtils.getNumBytes("short");
						size += JausUtils.getNumBytes("byte");
						size += m_TimeStamp.getSize();
						size += JausUtils.getNumBytes("byte");
						size += m_CompressedData.getSize();
						
						return size;
					}
					
					public void encode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						bytes.putShort(pos, (short) m_SensorID);
						pos += JausUtils.getNumBytes("short");
						bytes.put(pos, (byte) m_ReportCoordinateSystem);
						pos += JausUtils.getNumBytes("byte");
						m_TimeStamp.encode(bytes, pos);
						pos += m_TimeStamp.getSize();
						bytes.put(pos, (byte) m_DataCompression);
						pos += JausUtils.getNumBytes("byte");
						m_CompressedData.encode(bytes, pos);
						pos += m_CompressedData.getSize();
					}
					
					public void decode(ByteBuffer bytes, int pos)
					{
						
						if (bytes.array() == null)
						{
							return;
						}
						if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
						{
							bytes.order(ByteOrder.LITTLE_ENDIAN);
						}
						
						m_SensorID = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
						m_ReportCoordinateSystem = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						m_TimeStamp.decode(bytes, pos);
						pos += m_TimeStamp.getSize();
						m_DataCompression = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						m_CompressedData.decode(bytes, pos);
						pos += m_CompressedData.getSize();
					}
					
					public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec assign(RangeSensorCompressedDataRec value)
					{
						m_SensorID = value.m_SensorID;
						m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
						m_TimeStamp = value.m_TimeStamp;
						m_DataCompression = value.m_DataCompression;
						m_CompressedData = value.m_CompressedData;
						
						return this;
					}
					
					public boolean isEqual(RangeSensorCompressedDataRec value)
					{
						if (m_SensorID != value.getSensorID())
						{
							return false;
						}
						if (m_ReportCoordinateSystem != value.getReportCoordinateSystem())
						{
							return false;
						}
						
						if (!m_TimeStamp.isEqual(value.getTimeStamp()))
						{
							return false;
						}
						if (m_DataCompression != value.getDataCompression())
						{
							return false;
						}
						
						if (!m_CompressedData.isEqual(value.getCompressedData()))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(RangeSensorCompressedDataRec value)
					{
						return !this.isEqual(value);
					}
					
					public RangeSensorCompressedDataRec()
					{
						m_parent = null;
						m_SensorID = 0;
						m_ReportCoordinateSystem = 0;
						m_TimeStamp = new TimeStamp();
						m_TimeStamp.setParent(this);
						m_DataCompression = 0;
							m_CompressedData = new CompressedData();
						m_CompressedData.setParent(this);
					}
					
					public RangeSensorCompressedDataRec(RangeSensorCompressedDataRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SensorID = 0;
						m_ReportCoordinateSystem = 0;
						m_TimeStamp = new TimeStamp();
						m_TimeStamp.setParent(this);
						m_DataCompression = 0;
							m_CompressedData = new CompressedData();
						m_CompressedData.setParent(this);
						
						/// Copy the values
						m_SensorID = value.m_SensorID;
						m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
						m_TimeStamp = value.m_TimeStamp;
						m_DataCompression = value.m_DataCompression;
						m_CompressedData = value.m_CompressedData;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected RangeSensorCompressedDataList m_parent;
				protected short m_FieldValue;
				protected RangeSensorDataErrorRec m_RangeSensorDataErrorRec;
				protected RangeSensorCompressedDataRec m_RangeSensorCompressedDataRec;
			
				public void setParent(RangeSensorCompressedDataList parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setParentPresenceVector();
					}
				}
				
				public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorDataErrorRec getRangeSensorDataErrorRec()
				{
					return m_RangeSensorDataErrorRec;
				}
				
				public void setRangeSensorDataErrorRec(RangeSensorDataErrorRec value)
				{
					m_RangeSensorDataErrorRec = value;
					setParentPresenceVector();
				}
				
				public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant.RangeSensorCompressedDataRec getRangeSensorCompressedDataRec()
				{
					return m_RangeSensorCompressedDataRec;
				}
				
				public void setRangeSensorCompressedDataRec(RangeSensorCompressedDataRec value)
				{
					m_RangeSensorCompressedDataRec = value;
					setParentPresenceVector();
				}
				
				public short getFieldValue()
				{
					return m_FieldValue;
				}
				
				public void setFieldValue(short fieldValue)
				{
					if(fieldValue > 1)
					{
						return;
					}
					
					m_FieldValue = fieldValue;
					setParentPresenceVector();
				}
				
				/**
				 * Returns the number of bytes the used data members of the class occupies
				 * in the buffer. This is not the number of bytes the data type occupies in 
				 * Java, but the bytes expected on the wire.
				 * 
				 * @return
				 */
				public long getSize()
				{
					long size = 0;
					
					size += JausUtils.getNumBytes("byte");
					
					switch(m_FieldValue)
					{
						case 0:
							size += m_RangeSensorDataErrorRec.getSize();
							break;
						case 1:
							size += m_RangeSensorCompressedDataRec.getSize();
							break;
					}
					
					return size;
				}
				
				public void encode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					try
					{
					bytes.put(pos, (byte) m_FieldValue);
					pos += JausUtils.getNumBytes("byte");
					}
					catch (Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					
					switch(m_FieldValue)
					{
						case 0:
							m_RangeSensorDataErrorRec.encode(bytes, pos);
							pos += m_RangeSensorDataErrorRec.getSize();
							break;
						case 1:
							m_RangeSensorCompressedDataRec.encode(bytes, pos);
							pos += m_RangeSensorCompressedDataRec.getSize();
							break;
					}
				}
				
				public void decode(ByteBuffer bytes, int pos)
				{
					
					if (bytes.array() == null)
					{
						return;
					}
					if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
					{
						bytes.order(ByteOrder.LITTLE_ENDIAN);
					}
					
					
					try
					{
					m_FieldValue = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					}
					catch (Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					
					switch(m_FieldValue)
					{
						case 0:
							m_RangeSensorDataErrorRec.decode(bytes, pos);
							pos += m_RangeSensorDataErrorRec.getSize();
							break;
						case 1:
							m_RangeSensorCompressedDataRec.decode(bytes, pos);
							pos += m_RangeSensorCompressedDataRec.getSize();
							break;
					}
				}
				
				public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant assign(RangeSensorCompressedDataVariant value)
				{
					m_FieldValue = value.m_FieldValue;
					m_RangeSensorDataErrorRec = value.m_RangeSensorDataErrorRec;
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorCompressedDataRec = value.m_RangeSensorCompressedDataRec;
					m_RangeSensorCompressedDataRec.setParent(this);
					
					return this;
				}
				
				public boolean isEqual(RangeSensorCompressedDataVariant value)
				{
					if (m_FieldValue != value.m_FieldValue)
					{
						return false;
					}
					if (!m_RangeSensorDataErrorRec.isEqual(value.getRangeSensorDataErrorRec()))
					{
						return false;
					}
					if (!m_RangeSensorCompressedDataRec.isEqual(value.getRangeSensorCompressedDataRec()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RangeSensorCompressedDataVariant value)
				{
					return !this.isEqual(value);
				}
				
				public RangeSensorCompressedDataVariant()
				{
					m_parent = null;
					m_RangeSensorDataErrorRec = new RangeSensorDataErrorRec();
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorCompressedDataRec = new RangeSensorCompressedDataRec();
					m_RangeSensorCompressedDataRec.setParent(this);
				}
				
				public RangeSensorCompressedDataVariant(RangeSensorCompressedDataVariant value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RangeSensorDataErrorRec = new RangeSensorDataErrorRec();
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorCompressedDataRec = new RangeSensorCompressedDataRec();
					m_RangeSensorCompressedDataRec.setParent(this);
					
					/// Copy the values
					m_FieldValue = value.m_FieldValue;
					m_RangeSensorDataErrorRec = value.m_RangeSensorDataErrorRec;
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorCompressedDataRec = value.m_RangeSensorCompressedDataRec;
					m_RangeSensorCompressedDataRec.setParent(this);
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<RangeSensorCompressedDataVariant> m_RangeSensorCompressedDataVariant;
		
			public void setParent(Body parent)
			{
				m_parent = parent;
			}
			
			public void setParentPresenceVector()
			{
				if(m_parent != null )
				{
					m_parent.setParentPresenceVector();
				}
			}
			
			public long getNumberOfElements()
			{
				return (long) m_RangeSensorCompressedDataVariant.size();
			}
			
			public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList.RangeSensorCompressedDataVariant getElement(int index)
			{
				return m_RangeSensorCompressedDataVariant.get(index);
			}
			
			public void setElement(int index, RangeSensorCompressedDataVariant value)
			{
				if(m_RangeSensorCompressedDataVariant.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorCompressedDataVariant.get(index).assign(value);
				m_RangeSensorCompressedDataVariant.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(RangeSensorCompressedDataVariant value)
			{
				m_RangeSensorCompressedDataVariant.add(value);
				m_RangeSensorCompressedDataVariant.get(m_RangeSensorCompressedDataVariant.size()-1).setParent(this);
				setParentPresenceVector();
			}
			
			public void deleteElement(int index)
			{
				if(m_RangeSensorCompressedDataVariant.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorCompressedDataVariant.remove(index);
			}
			
			public void  deleteLastElement()
			{
				m_RangeSensorCompressedDataVariant.remove(m_RangeSensorCompressedDataVariant.size() -1);
			}
			
			/**
			 * Returns the number of bytes the used data members of the class occupies
			 * in the buffer. This is not the number of bytes the data type occupies in 
			 * Java, but the bytes expected on the wire.
			 * 
			 * @return
			 */
			public long getSize()
			{
				long size = 0;
				
				size += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_RangeSensorCompressedDataVariant.size(); i++)
				{
					size += m_RangeSensorCompressedDataVariant.get(i).getSize();
				}
				
				return size;
			}
			
			public void encode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				int size = (int) m_RangeSensorCompressedDataVariant.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_RangeSensorCompressedDataVariant.size(); i++)
				{
					m_RangeSensorCompressedDataVariant.get(i).encode(bytes, pos);
					pos += m_RangeSensorCompressedDataVariant.get(i).getSize();
				}
			}
			
			public void decode(ByteBuffer bytes, int pos)
			{
				
				if (bytes.array() == null)
				{
					return;
				}
				if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
				{
					bytes.order(ByteOrder.LITTLE_ENDIAN);
				}
				
				int size;
				size = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_RangeSensorCompressedDataVariant = new ArrayList<RangeSensorCompressedDataVariant>();
				for (int i = 0; i < size; i++)
				{
					m_RangeSensorCompressedDataVariant.add(new RangeSensorCompressedDataVariant());
					m_RangeSensorCompressedDataVariant.get(i).decode(bytes, pos);
					pos += m_RangeSensorCompressedDataVariant.get(i).getSize();
				}
			}
			
			public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList assign(RangeSensorCompressedDataList value)
			{
				m_RangeSensorCompressedDataVariant.clear();
				
				for (int i = 0; i < value.m_RangeSensorCompressedDataVariant.size(); i++)
				{
					m_RangeSensorCompressedDataVariant.add(value.m_RangeSensorCompressedDataVariant.get(i));
					m_RangeSensorCompressedDataVariant.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorCompressedDataList value)
			{
				for (int i = 0; i < m_RangeSensorCompressedDataVariant.size(); i++)
				{
					if (m_RangeSensorCompressedDataVariant.get(i) != value.m_RangeSensorCompressedDataVariant.get(i))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(RangeSensorCompressedDataList value)
			{
				return !this.isEqual(value);
			}
			
			public RangeSensorCompressedDataList()
			{
				m_parent = null;
				m_RangeSensorCompressedDataVariant = new ArrayList<RangeSensorCompressedDataVariant>();
				for (int i = 0; i < m_RangeSensorCompressedDataVariant.size(); i++)
				{
					m_RangeSensorCompressedDataVariant.get(i).setParent(this);
				}
			}
			
			public RangeSensorCompressedDataList(RangeSensorCompressedDataList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RangeSensorCompressedDataVariant = new ArrayList<RangeSensorCompressedDataVariant>();
				for (int i = 0; i < m_RangeSensorCompressedDataVariant.size(); i++)
				{
					m_RangeSensorCompressedDataVariant.get(i).setParent(this);
				}
				
				/// Copy the values
				m_RangeSensorCompressedDataVariant.clear();
				
				for (int i = 0; i < value.m_RangeSensorCompressedDataVariant.size(); i++)
				{
					m_RangeSensorCompressedDataVariant.add(value.m_RangeSensorCompressedDataVariant.get(i));
					m_RangeSensorCompressedDataVariant.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorCompressedDataList m_RangeSensorCompressedDataList;
	
		public ReportRangeSensorCompressedData.Body.RangeSensorCompressedDataList getRangeSensorCompressedDataList()
		{
			return m_RangeSensorCompressedDataList;
		}
		
		public void setRangeSensorCompressedDataList(RangeSensorCompressedDataList value)
		{
			m_RangeSensorCompressedDataList = value;
			setParentPresenceVector();
		}
		
		public void setParentPresenceVector()
		{
			// Nothing needed here, placeholder function
		}
		
		/**
		 * Returns the number of bytes the used data members of the class occupies
		 * in the buffer. This is not the number of bytes the data type occupies in 
		 * Java, but the bytes expected on the wire.
		 * 
		 * @return
		 */
		public long getSize()
		{
			long size = 0;
			
			size += m_RangeSensorCompressedDataList.getSize();
			
			return size;
		}
		
		public void encode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_RangeSensorCompressedDataList.encode(bytes, pos);
			pos += m_RangeSensorCompressedDataList.getSize();
		}
		
		public void decode(ByteBuffer bytes, int pos)
		{
			
			if (bytes.array() == null)
			{
				return;
			}
			if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
			{
				bytes.order(ByteOrder.LITTLE_ENDIAN);
			}
			
			m_RangeSensorCompressedDataList.decode(bytes, pos);
			pos += m_RangeSensorCompressedDataList.getSize();
		}
		
		public ReportRangeSensorCompressedData.Body assign(Body value)
		{
			m_RangeSensorCompressedDataList = value.m_RangeSensorCompressedDataList;
			m_RangeSensorCompressedDataList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_RangeSensorCompressedDataList.isEqual(value.m_RangeSensorCompressedDataList))
			{
				return false;
			}
			/// This code is currently not supported
			return true;
		}
		
		public boolean notEquals(Body value)
		{
			return !this.isEqual(value);
		}
		
		public Body()
		{
			m_RangeSensorCompressedDataList = new RangeSensorCompressedDataList();
			m_RangeSensorCompressedDataList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_RangeSensorCompressedDataList = new RangeSensorCompressedDataList();
			m_RangeSensorCompressedDataList.setParent(this);
			
			/// Copy the values
			m_RangeSensorCompressedDataList = value.m_RangeSensorCompressedDataList;
			m_RangeSensorCompressedDataList.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected AppHeader m_AppHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public ReportRangeSensorCompressedData.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportRangeSensorCompressedData.Body getBody()
	{
		return m_Body;
	}
	
	public int setBody(Body value)
	{
		m_Body = value;
		return 0;
	}
	
	/**
	 * Returns the number of bytes the used data members of the class occupies
	 * in the buffer. This is not the number of bytes the data type occupies in 
	 * Java, but the bytes expected on the wire.
	 * 
	 * @return
	 */
	public long getSize()
	{
		int size = 0;
		
		size += m_AppHeader.getSize();
		size += m_Body.getSize();
		
		return size;
	}
	
	public void encode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_AppHeader.encode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.encode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public void decode(ByteBuffer bytes, int pos)
	{
		
		if (bytes.array() == null)
		{
			return;
		}
		if(bytes.order() != ByteOrder.LITTLE_ENDIAN)
		{
			bytes.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		m_AppHeader.decode(bytes, pos);
		pos += m_AppHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public ReportRangeSensorCompressedData setAs(ReportRangeSensorCompressedData value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportRangeSensorCompressedData value)
	{
		if (!m_AppHeader.isEqual(value.getAppHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(ReportRangeSensorCompressedData value)
	{
		return !isEqual(value);
	}
	
	public ReportRangeSensorCompressedData()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportRangeSensorCompressedData(ReportRangeSensorCompressedData value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}

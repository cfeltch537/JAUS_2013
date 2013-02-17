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

public class ReportRangeSensorData extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4803;
	
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
			
			public ReportRangeSensorData.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4803;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4803;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportRangeSensorData.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportRangeSensorData.AppHeader assign(AppHeader value)
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
		public static class  RangeSensorDataList
		{
			public static class  RangeSensorDataVariant
			{
				public static class  RangeSensorDataErrorRec
				{
				
					protected RangeSensorDataVariant m_parent;
					protected int m_SensorID;
					protected short m_DataErrorCode;
					protected String m_ErrorMessage;
				
					public void setParent(RangeSensorDataVariant parent)
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
					
					public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataErrorRec assign(RangeSensorDataErrorRec value)
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
				public static class  RangeSensorDataSeq
				{
					public static class  RangeSensorDataRec
					{
						public static class  TimeStamp
						{
						
							protected RangeSensorDataRec m_parent;
							protected long m_SubFields;
						
							public void setParent(RangeSensorDataRec parent)
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
							
							public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataRec.TimeStamp assign(TimeStamp value)
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
					
					
						protected RangeSensorDataSeq m_parent;
						protected int m_SensorID;
						protected short m_ReportCoordinateSystem;
						protected TimeStamp m_TimeStamp;
					
						public void setParent(RangeSensorDataSeq parent)
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
						
						public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataRec.TimeStamp getTimeStamp()
						{
							return m_TimeStamp;
						}
						
						public void setTimeStamp(TimeStamp value)
						{
							m_TimeStamp = value;
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
						}
						
						public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataRec assign(RangeSensorDataRec value)
						{
							m_SensorID = value.m_SensorID;
							m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
							m_TimeStamp = value.m_TimeStamp;
							
							return this;
						}
						
						public boolean isEqual(RangeSensorDataRec value)
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
							
							return true;
						}
						
						public boolean notEquals(RangeSensorDataRec value)
						{
							return !this.isEqual(value);
						}
						
						public RangeSensorDataRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_ReportCoordinateSystem = 0;
							m_TimeStamp = new TimeStamp();
							m_TimeStamp.setParent(this);
						}
						
						public RangeSensorDataRec(RangeSensorDataRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_ReportCoordinateSystem = 0;
							m_TimeStamp = new TimeStamp();
							m_TimeStamp.setParent(this);
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_ReportCoordinateSystem = value.m_ReportCoordinateSystem;
							m_TimeStamp = value.m_TimeStamp;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  RangeSensorDataPointList
					{
						public static class  RangeSensorDataPointRec
						{
						
							protected RangeSensorDataPointList m_parent;
							protected BitSet m_PresenceVector;
							protected short m_PresenceVectorTemp;
							protected long m_PointID;
							protected long m_Range;
							protected short m_RangeValidity;
							protected long m_RangeErrorRMS;
							protected long m_Bearing;
							protected short m_BearingValidity;
							protected long m_BearingErrorRMS;
							protected long m_Inclination;
							protected short m_InclinationValidity;
							protected long m_InclinationErrorRMS;
						
							public void setParent(RangeSensorDataPointList parent)
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
							
							public short getPresenceVector()
							{
								return m_PresenceVectorTemp;
							}
							
							protected void setPresenceVector(int index)
							{
								
								m_PresenceVector.set(index);
								m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
							}
							
							public boolean checkPresenceVector(int index)
							{
								
								return m_PresenceVector.get(index);
							}
							
							public boolean isPointIDValid()
							{
								if (checkPresenceVector(0))
								{
									return true;
								}
								return false;
							}
							
							public long getPointID()
							{
								return m_PointID;
							}
							
							public void setPointID(long value)
							{
								m_PointID = value;
								setPresenceVector(0);
								setParentPresenceVector();
							}
							
							public double getRange()
							{
								double value;
								
								double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
								double bias = 0;
								
								value = m_Range * scaleFactor + bias;
								
								return value;
							}
							
							public void setRange(double value)
							{
								if ((value >= 0) && (value <= 1000000.0))
								{
									double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
									double bias = 0;
									
									m_Range= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isRangeValidityValid()
							{
								if (checkPresenceVector(1))
								{
									return true;
								}
								return false;
							}
							
							public short getRangeValidity()
							{
								return m_RangeValidity;
							}
							
							public void setRangeValidity(short value)
							{
								if ((value == 0) || (value == 1))
								{
									m_RangeValidity = value;
									setPresenceVector(1);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isRangeErrorRMSValid()
							{
								if (checkPresenceVector(2))
								{
									return true;
								}
								return false;
							}
							
							public double getRangeErrorRMS()
							{
								double value;
								
								double scaleFactor = ( 100000.0 - 0.0 ) / 4.294967295E9;
								double bias = 0.0;
								
								value = m_RangeErrorRMS * scaleFactor + bias;
								
								return value;
							}
							
							public void setRangeErrorRMS(double value)
							{
								if ((value >= 0.0) && (value <= 100000.0))
								{
									double scaleFactor = ( 100000.0 - 0.0 ) / 4.294967295E9;
									double bias = 0.0;
									
									m_RangeErrorRMS= (long)((value - bias) / scaleFactor);
									setPresenceVector(2);
									setParentPresenceVector();
								}
								return;
							}
							
							public double getBearing()
							{
								double value;
								
								double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
								double bias = -3.141592653589793;
								
								value = m_Bearing * scaleFactor + bias;
								
								return value;
							}
							
							public void setBearing(double value)
							{
								if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
								{
									double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
									double bias = -3.141592653589793;
									
									m_Bearing= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isBearingValidityValid()
							{
								if (checkPresenceVector(3))
								{
									return true;
								}
								return false;
							}
							
							public short getBearingValidity()
							{
								return m_BearingValidity;
							}
							
							public void setBearingValidity(short value)
							{
								if ((value == 0) || (value == 1))
								{
									m_BearingValidity = value;
									setPresenceVector(3);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isBearingErrorRMSValid()
							{
								if (checkPresenceVector(4))
								{
									return true;
								}
								return false;
							}
							
							public double getBearingErrorRMS()
							{
								double value;
								
								double scaleFactor = ( 3.141592653589793 - 0 ) / 4.294967295E9;
								double bias = 0;
								
								value = m_BearingErrorRMS * scaleFactor + bias;
								
								return value;
							}
							
							public void setBearingErrorRMS(double value)
							{
								if ((value >= 0) && (value <= 3.141592653589793))
								{
									double scaleFactor = ( 3.141592653589793 - 0 ) / 4.294967295E9;
									double bias = 0;
									
									m_BearingErrorRMS= (long)((value - bias) / scaleFactor);
									setPresenceVector(4);
									setParentPresenceVector();
								}
								return;
							}
							
							public double getInclination()
							{
								double value;
								
								double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
								double bias = -3.141592653589793;
								
								value = m_Inclination * scaleFactor + bias;
								
								return value;
							}
							
							public void setInclination(double value)
							{
								if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
								{
									double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
									double bias = -3.141592653589793;
									
									m_Inclination= (long)((value - bias) / scaleFactor);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isInclinationValidityValid()
							{
								if (checkPresenceVector(5))
								{
									return true;
								}
								return false;
							}
							
							public short getInclinationValidity()
							{
								return m_InclinationValidity;
							}
							
							public void setInclinationValidity(short value)
							{
								if ((value == 0) || (value == 1))
								{
									m_InclinationValidity = value;
									setPresenceVector(5);
									setParentPresenceVector();
								}
								return;
							}
							
							public boolean isInclinationErrorRMSValid()
							{
								if (checkPresenceVector(6))
								{
									return true;
								}
								return false;
							}
							
							public double getInclinationErrorRMS()
							{
								double value;
								
								double scaleFactor = ( 3.141592653589793 - 0.0 ) / 4.294967295E9;
								double bias = 0.0;
								
								value = m_InclinationErrorRMS * scaleFactor + bias;
								
								return value;
							}
							
							public void setInclinationErrorRMS(double value)
							{
								if ((value >= 0.0) && (value <= 3.141592653589793))
								{
									double scaleFactor = ( 3.141592653589793 - 0.0 ) / 4.294967295E9;
									double bias = 0.0;
									
									m_InclinationErrorRMS= (long)((value - bias) / scaleFactor);
									setPresenceVector(6);
									setParentPresenceVector();
								}
								return;
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
								if (checkPresenceVector(0))
								{
									size += JausUtils.getNumBytes("int");
								}
								size += JausUtils.getNumBytes("int");
								if (checkPresenceVector(1))
								{
									size += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(2))
								{
									size += JausUtils.getNumBytes("int");
								}
								size += JausUtils.getNumBytes("int");
								if (checkPresenceVector(3))
								{
									size += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(4))
								{
									size += JausUtils.getNumBytes("int");
								}
								size += JausUtils.getNumBytes("int");
								if (checkPresenceVector(5))
								{
									size += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(6))
								{
									size += JausUtils.getNumBytes("int");
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
									short m_PresenceVectorTemp = (short) JausUtils.getPVInt(m_PresenceVector);
								bytes.put(pos, (byte) m_PresenceVectorTemp);
								pos += JausUtils.getNumBytes("byte");
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
								if (checkPresenceVector(0))
								{
									bytes.putInt(pos, (int) m_PointID);
									pos += JausUtils.getNumBytes("int");
								}
								bytes.putInt(pos, (int) m_Range);
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(1))
								{
									bytes.put(pos, (byte) m_RangeValidity);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(2))
								{
									bytes.putInt(pos, (int) m_RangeErrorRMS);
									pos += JausUtils.getNumBytes("int");
								}
								bytes.putInt(pos, (int) m_Bearing);
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(3))
								{
									bytes.put(pos, (byte) m_BearingValidity);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(4))
								{
									bytes.putInt(pos, (int) m_BearingErrorRMS);
									pos += JausUtils.getNumBytes("int");
								}
								bytes.putInt(pos, (int) m_Inclination);
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(5))
								{
									bytes.put(pos, (byte) m_InclinationValidity);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(6))
								{
									bytes.putInt(pos, (int) m_InclinationErrorRMS);
									pos += JausUtils.getNumBytes("int");
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
									short m_PresenceVectorTemp = 0;
								m_PresenceVectorTemp = (short) (bytes.get(pos) & 0xff);
								pos += JausUtils.getNumBytes("byte");
								m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
								}
								catch(Exception e)
								{
									logger.log(Level.SEVERE, null, e);
								}
								if (checkPresenceVector(0))
								{
									m_PointID = bytes.getInt(pos) & 0xffffffffL;
									pos += JausUtils.getNumBytes("int");
								}
								m_Range = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(1))
								{
									m_RangeValidity = (short) (bytes.get(pos) & 0xff);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(2))
								{
									m_RangeErrorRMS = bytes.getInt(pos) & 0xffffffffL;
									pos += JausUtils.getNumBytes("int");
								}
								m_Bearing = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(3))
								{
									m_BearingValidity = (short) (bytes.get(pos) & 0xff);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(4))
								{
									m_BearingErrorRMS = bytes.getInt(pos) & 0xffffffffL;
									pos += JausUtils.getNumBytes("int");
								}
								m_Inclination = bytes.getInt(pos) & 0xffffffffL;
								pos += JausUtils.getNumBytes("int");
								if (checkPresenceVector(5))
								{
									m_InclinationValidity = (short) (bytes.get(pos) & 0xff);
									pos += JausUtils.getNumBytes("byte");
								}
								if (checkPresenceVector(6))
								{
									m_InclinationErrorRMS = bytes.getInt(pos) & 0xffffffffL;
									pos += JausUtils.getNumBytes("int");
								}
							}
							
							public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataPointList.RangeSensorDataPointRec assign(RangeSensorDataPointRec value)
							{
								m_PresenceVector = value.m_PresenceVector;
								m_PointID = value.m_PointID;
								m_Range = value.m_Range;
								m_RangeValidity = value.m_RangeValidity;
								m_RangeErrorRMS = value.m_RangeErrorRMS;
								m_Bearing = value.m_Bearing;
								m_BearingValidity = value.m_BearingValidity;
								m_BearingErrorRMS = value.m_BearingErrorRMS;
								m_Inclination = value.m_Inclination;
								m_InclinationValidity = value.m_InclinationValidity;
								m_InclinationErrorRMS = value.m_InclinationErrorRMS;
								
								return this;
							}
							
							public boolean isEqual(RangeSensorDataPointRec value)
							{
								if (!m_PresenceVector.equals(value.m_PresenceVector))
								{
									return false;
								}
								if (m_PointID != value.getPointID())
								{
									return false;
								}
								if (m_Range != value.getRange())
								{
									return false;
								}
								if (m_RangeValidity != value.getRangeValidity())
								{
									return false;
								}
								if (m_RangeErrorRMS != value.getRangeErrorRMS())
								{
									return false;
								}
								if (m_Bearing != value.getBearing())
								{
									return false;
								}
								if (m_BearingValidity != value.getBearingValidity())
								{
									return false;
								}
								if (m_BearingErrorRMS != value.getBearingErrorRMS())
								{
									return false;
								}
								if (m_Inclination != value.getInclination())
								{
									return false;
								}
								if (m_InclinationValidity != value.getInclinationValidity())
								{
									return false;
								}
								if (m_InclinationErrorRMS != value.getInclinationErrorRMS())
								{
									return false;
								}
								
								return true;
							}
							
							public boolean notEquals(RangeSensorDataPointRec value)
							{
								return !this.isEqual(value);
							}
							
							public RangeSensorDataPointRec()
							{
								m_parent = null;
								m_PresenceVector = new BitSet();
								m_PresenceVectorTemp = 0;
								m_PointID = 0;
								m_Range = 0;
								m_RangeValidity = 0;
								m_RangeErrorRMS = 0;
								m_Bearing = 0;
								m_BearingValidity = 0;
								m_BearingErrorRMS = 0;
								m_Inclination = 0;
								m_InclinationValidity = 0;
								m_InclinationErrorRMS = 0;
							}
							
							public RangeSensorDataPointRec(RangeSensorDataPointRec value)
							{
								/// Initiliaze the protected variables
								m_parent = null;
								m_PresenceVector = new BitSet();
								m_PresenceVectorTemp = 0;
								m_PointID = 0;
								m_Range = 0;
								m_RangeValidity = 0;
								m_RangeErrorRMS = 0;
								m_Bearing = 0;
								m_BearingValidity = 0;
								m_BearingErrorRMS = 0;
								m_Inclination = 0;
								m_InclinationValidity = 0;
								m_InclinationErrorRMS = 0;
								
								/// Copy the values
								m_PresenceVector = value.m_PresenceVector;
								m_PointID = value.m_PointID;
								m_Range = value.m_Range;
								m_RangeValidity = value.m_RangeValidity;
								m_RangeErrorRMS = value.m_RangeErrorRMS;
								m_Bearing = value.m_Bearing;
								m_BearingValidity = value.m_BearingValidity;
								m_BearingErrorRMS = value.m_BearingErrorRMS;
								m_Inclination = value.m_Inclination;
								m_InclinationValidity = value.m_InclinationValidity;
								m_InclinationErrorRMS = value.m_InclinationErrorRMS;
							}
							
							public void finalize()
							{
							}
							
						}
					
					
						protected RangeSensorDataSeq m_parent;
						protected ArrayList<RangeSensorDataPointRec> m_RangeSensorDataPointRec;
					
						public void setParent(RangeSensorDataSeq parent)
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
							return (long) m_RangeSensorDataPointRec.size();
						}
						
						public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataPointList.RangeSensorDataPointRec getElement(int index)
						{
							return m_RangeSensorDataPointRec.get(index);
						}
						
						public void setElement(int index, RangeSensorDataPointRec value)
						{
							if(m_RangeSensorDataPointRec.size()-1 < index)
							{
								return;
							}
							
							m_RangeSensorDataPointRec.set(index, value);
							m_RangeSensorDataPointRec.get(index).setParent(this);
							setParentPresenceVector();
						}
						
						public void addElement(RangeSensorDataPointRec value)
						{
							m_RangeSensorDataPointRec.add(value);
							m_RangeSensorDataPointRec.get(m_RangeSensorDataPointRec.size() -1 ).setParent(this);
							setParentPresenceVector();
						}
						
						public int deleteElement(int index)
						{
							if(m_RangeSensorDataPointRec.size()-1 < index)
							{
								return 1;
							}
							
							m_RangeSensorDataPointRec.remove(index);
							return 0;
						}
						
						public int deleteLastElement()
						{
							m_RangeSensorDataPointRec.remove(m_RangeSensorDataPointRec.size()-1);
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
							long size = 0;
							
							size += JausUtils.getNumBytes("short");
							for (int i = 0; i < m_RangeSensorDataPointRec.size(); i++)
							{
								size += m_RangeSensorDataPointRec.get(i).getSize();
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
							
							int size = (int) m_RangeSensorDataPointRec.size();
							bytes.putShort(pos, (short) size);
							pos += JausUtils.getNumBytes("short");
							for (int i = 0; i < m_RangeSensorDataPointRec.size(); i++)
							{
								m_RangeSensorDataPointRec.get(i).encode(bytes, pos);
								pos += m_RangeSensorDataPointRec.get(i).getSize();
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
							m_RangeSensorDataPointRec = new ArrayList<RangeSensorDataPointRec>();
							for (int i = 0; i <  size; i++)
							{
								RangeSensorDataPointRec item = new RangeSensorDataPointRec();
								item.decode(bytes, pos);
								m_RangeSensorDataPointRec.add(item);
								pos += item.getSize();
							}
						}
						
						public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataPointList assign(RangeSensorDataPointList value)
						{
							m_RangeSensorDataPointRec.clear();
							
							for (int i = 0; i < value.m_RangeSensorDataPointRec.size(); i++)
							{
								m_RangeSensorDataPointRec.add(value.m_RangeSensorDataPointRec.get(i));
								m_RangeSensorDataPointRec.get(i).setParent(this);
							}
							
							return this;
						}
						
						public boolean isEqual(RangeSensorDataPointList value)
						{
							for (int i = 0; i < m_RangeSensorDataPointRec.size(); i++)
							{
								if (!m_RangeSensorDataPointRec.get(i).isEqual(value.getElement(i)))
								{
									return false;
								}
							}
							
							return true;
						}
						
						public boolean notEquals(RangeSensorDataPointList value)
						{
							return !this.isEqual(value);
						}
						
						public RangeSensorDataPointList()
						{
							m_parent = null;
							m_RangeSensorDataPointRec = new ArrayList<RangeSensorDataPointRec>();
							for (int i = 0; i < m_RangeSensorDataPointRec.size(); i++)
							{
								m_RangeSensorDataPointRec.get(i).setParent(this);
							}
						}
						
						public RangeSensorDataPointList(RangeSensorDataPointList value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_RangeSensorDataPointRec = new ArrayList<RangeSensorDataPointRec>();
							for (int i = 0; i < m_RangeSensorDataPointRec.size(); i++)
							{
								m_RangeSensorDataPointRec.get(i).setParent(this);
							}
							
							/// Copy the values
							m_RangeSensorDataPointRec.clear();
							
							for (int i = 0; i < value.m_RangeSensorDataPointRec.size(); i++)
							{
								m_RangeSensorDataPointRec.add(value.m_RangeSensorDataPointRec.get(i));
								m_RangeSensorDataPointRec.get(i).setParent(this);
							}
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected RangeSensorDataVariant m_parent;
					protected RangeSensorDataRec m_RangeSensorDataRec;
					protected RangeSensorDataPointList m_RangeSensorDataPointList;
				
					public void setParent(RangeSensorDataVariant parent)
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
					
					public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataRec getRangeSensorDataRec()
					{
						return m_RangeSensorDataRec;
					}
					
					public void setRangeSensorDataRec(RangeSensorDataRec value)
					{
						m_RangeSensorDataRec = value;
						setParentPresenceVector();
					}
					
					public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq.RangeSensorDataPointList getRangeSensorDataPointList()
					{
						return m_RangeSensorDataPointList;
					}
					
					public void setRangeSensorDataPointList(RangeSensorDataPointList value)
					{
						m_RangeSensorDataPointList = value;
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
						
						size += m_RangeSensorDataRec.getSize();
						size += m_RangeSensorDataPointList.getSize();
						
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
						
						m_RangeSensorDataRec.encode(bytes, pos);
						pos += m_RangeSensorDataRec.getSize();
						m_RangeSensorDataPointList.encode(bytes, pos);
						pos += m_RangeSensorDataPointList.getSize();
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
						
						m_RangeSensorDataRec.decode(bytes, pos);
						pos += m_RangeSensorDataRec.getSize();
						m_RangeSensorDataPointList.decode(bytes, pos);
						pos += m_RangeSensorDataPointList.getSize();
					}
					
					public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq assign(RangeSensorDataSeq value)
					{
						m_RangeSensorDataRec = value.m_RangeSensorDataRec;
						m_RangeSensorDataRec.setParent(this);
						m_RangeSensorDataRec = value.m_RangeSensorDataRec;
						m_RangeSensorDataPointList = value.m_RangeSensorDataPointList;
						m_RangeSensorDataPointList.setParent(this);
						m_RangeSensorDataPointList = value.m_RangeSensorDataPointList;
						
						return this;
					}
					
					public boolean isEqual(RangeSensorDataSeq value)
					{
						if (!m_RangeSensorDataRec.isEqual(value.getRangeSensorDataRec()))
						{
							return false;
						}
						
						if (!m_RangeSensorDataRec.isEqual(value.getRangeSensorDataRec()))
						{
							return false;
						}
						if (!m_RangeSensorDataPointList.isEqual(value.m_RangeSensorDataPointList))
						{
							return false;
						}
						
						if (!m_RangeSensorDataPointList.isEqual(value.getRangeSensorDataPointList()))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(RangeSensorDataSeq value)
					{
						return !this.isEqual(value);
					}
					
					public RangeSensorDataSeq()
					{
						m_parent = null;
						m_RangeSensorDataRec = new RangeSensorDataRec();
						m_RangeSensorDataRec.setParent(this);
						m_RangeSensorDataPointList = new RangeSensorDataPointList();
						m_RangeSensorDataPointList.setParent(this);
					}
					
					public RangeSensorDataSeq(RangeSensorDataSeq value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_RangeSensorDataRec = new RangeSensorDataRec();
						m_RangeSensorDataRec.setParent(this);
						m_RangeSensorDataPointList = new RangeSensorDataPointList();
						m_RangeSensorDataPointList.setParent(this);
						
						/// Copy the values
						m_RangeSensorDataRec = value.m_RangeSensorDataRec;
						m_RangeSensorDataRec.setParent(this);
						m_RangeSensorDataRec = value.m_RangeSensorDataRec;
						m_RangeSensorDataPointList = value.m_RangeSensorDataPointList;
						m_RangeSensorDataPointList.setParent(this);
						m_RangeSensorDataPointList = value.m_RangeSensorDataPointList;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected RangeSensorDataList m_parent;
				protected short m_FieldValue;
				protected RangeSensorDataErrorRec m_RangeSensorDataErrorRec;
				protected RangeSensorDataSeq m_RangeSensorDataSeq;
			
				public void setParent(RangeSensorDataList parent)
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
				
				public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataErrorRec getRangeSensorDataErrorRec()
				{
					return m_RangeSensorDataErrorRec;
				}
				
				public void setRangeSensorDataErrorRec(RangeSensorDataErrorRec value)
				{
					m_RangeSensorDataErrorRec = value;
					setParentPresenceVector();
				}
				
				public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant.RangeSensorDataSeq getRangeSensorDataSeq()
				{
					return m_RangeSensorDataSeq;
				}
				
				public int setRangeSensorDataSeq(RangeSensorDataSeq value)
				{
					m_RangeSensorDataSeq = value;
					setParentPresenceVector();
					return 0;
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
							size += m_RangeSensorDataSeq.getSize();
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
							m_RangeSensorDataSeq.encode(bytes, pos);
							pos += m_RangeSensorDataSeq.getSize();
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
							m_RangeSensorDataSeq.decode(bytes, pos);
							pos += m_RangeSensorDataSeq.getSize();
							break;
					}
				}
				
				public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant assign(RangeSensorDataVariant value)
				{
					m_FieldValue = value.m_FieldValue;
					m_RangeSensorDataErrorRec = value.m_RangeSensorDataErrorRec;
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorDataSeq = value.m_RangeSensorDataSeq;
					m_RangeSensorDataSeq.setParent(this);
					
					return this;
				}
				
				public boolean isEqual(RangeSensorDataVariant value)
				{
					if (m_FieldValue != value.m_FieldValue)
					{
						return false;
					}
					if (!m_RangeSensorDataErrorRec.isEqual(value.getRangeSensorDataErrorRec()))
					{
						return false;
					}
					if (!m_RangeSensorDataSeq.isEqual(value.getRangeSensorDataSeq()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RangeSensorDataVariant value)
				{
					return !this.isEqual(value);
				}
				
				public RangeSensorDataVariant()
				{
					m_parent = null;
					m_RangeSensorDataErrorRec = new RangeSensorDataErrorRec();
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorDataSeq = new RangeSensorDataSeq();
					m_RangeSensorDataSeq.setParent(this);
				}
				
				public RangeSensorDataVariant(RangeSensorDataVariant value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RangeSensorDataErrorRec = new RangeSensorDataErrorRec();
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorDataSeq = new RangeSensorDataSeq();
					m_RangeSensorDataSeq.setParent(this);
					
					/// Copy the values
					m_FieldValue = value.m_FieldValue;
					m_RangeSensorDataErrorRec = value.m_RangeSensorDataErrorRec;
					m_RangeSensorDataErrorRec.setParent(this);
					m_RangeSensorDataSeq = value.m_RangeSensorDataSeq;
					m_RangeSensorDataSeq.setParent(this);
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<RangeSensorDataVariant> m_RangeSensorDataVariant;
		
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
				return (long) m_RangeSensorDataVariant.size();
			}
			
			public ReportRangeSensorData.Body.RangeSensorDataList.RangeSensorDataVariant getElement(int index)
			{
				return m_RangeSensorDataVariant.get(index);
			}
			
			public void setElement(int index, RangeSensorDataVariant value)
			{
				if(m_RangeSensorDataVariant.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorDataVariant.get(index).assign(value);
				m_RangeSensorDataVariant.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(RangeSensorDataVariant value)
			{
				m_RangeSensorDataVariant.add(value);
				m_RangeSensorDataVariant.get(m_RangeSensorDataVariant.size()-1).setParent(this);
				setParentPresenceVector();
			}
			
			public void deleteElement(int index)
			{
				if(m_RangeSensorDataVariant.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorDataVariant.remove(index);
			}
			
			public void  deleteLastElement()
			{
				m_RangeSensorDataVariant.remove(m_RangeSensorDataVariant.size() -1);
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
				for (int i = 0; i < m_RangeSensorDataVariant.size(); i++)
				{
					size += m_RangeSensorDataVariant.get(i).getSize();
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
				
				int size = (int) m_RangeSensorDataVariant.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_RangeSensorDataVariant.size(); i++)
				{
					m_RangeSensorDataVariant.get(i).encode(bytes, pos);
					pos += m_RangeSensorDataVariant.get(i).getSize();
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
				m_RangeSensorDataVariant = new ArrayList<RangeSensorDataVariant>();
				for (int i = 0; i < size; i++)
				{
					m_RangeSensorDataVariant.add(new RangeSensorDataVariant());
					m_RangeSensorDataVariant.get(i).decode(bytes, pos);
					pos += m_RangeSensorDataVariant.get(i).getSize();
				}
			}
			
			public ReportRangeSensorData.Body.RangeSensorDataList assign(RangeSensorDataList value)
			{
				m_RangeSensorDataVariant.clear();
				
				for (int i = 0; i < value.m_RangeSensorDataVariant.size(); i++)
				{
					m_RangeSensorDataVariant.add(value.m_RangeSensorDataVariant.get(i));
					m_RangeSensorDataVariant.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorDataList value)
			{
				for (int i = 0; i < m_RangeSensorDataVariant.size(); i++)
				{
					if (m_RangeSensorDataVariant.get(i) != value.m_RangeSensorDataVariant.get(i))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(RangeSensorDataList value)
			{
				return !this.isEqual(value);
			}
			
			public RangeSensorDataList()
			{
				m_parent = null;
				m_RangeSensorDataVariant = new ArrayList<RangeSensorDataVariant>();
				for (int i = 0; i < m_RangeSensorDataVariant.size(); i++)
				{
					m_RangeSensorDataVariant.get(i).setParent(this);
				}
			}
			
			public RangeSensorDataList(RangeSensorDataList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RangeSensorDataVariant = new ArrayList<RangeSensorDataVariant>();
				for (int i = 0; i < m_RangeSensorDataVariant.size(); i++)
				{
					m_RangeSensorDataVariant.get(i).setParent(this);
				}
				
				/// Copy the values
				m_RangeSensorDataVariant.clear();
				
				for (int i = 0; i < value.m_RangeSensorDataVariant.size(); i++)
				{
					m_RangeSensorDataVariant.add(value.m_RangeSensorDataVariant.get(i));
					m_RangeSensorDataVariant.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorDataList m_RangeSensorDataList;
	
		public ReportRangeSensorData.Body.RangeSensorDataList getRangeSensorDataList()
		{
			return m_RangeSensorDataList;
		}
		
		public void setRangeSensorDataList(RangeSensorDataList value)
		{
			m_RangeSensorDataList = value;
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
			
			size += m_RangeSensorDataList.getSize();
			
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
			
			m_RangeSensorDataList.encode(bytes, pos);
			pos += m_RangeSensorDataList.getSize();
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
			
			m_RangeSensorDataList.decode(bytes, pos);
			pos += m_RangeSensorDataList.getSize();
		}
		
		public ReportRangeSensorData.Body assign(Body value)
		{
			m_RangeSensorDataList = value.m_RangeSensorDataList;
			m_RangeSensorDataList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_RangeSensorDataList.isEqual(value.m_RangeSensorDataList))
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
			m_RangeSensorDataList = new RangeSensorDataList();
			m_RangeSensorDataList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_RangeSensorDataList = new RangeSensorDataList();
			m_RangeSensorDataList.setParent(this);
			
			/// Copy the values
			m_RangeSensorDataList = value.m_RangeSensorDataList;
			m_RangeSensorDataList.setParent(this);
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
	public ReportRangeSensorData.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportRangeSensorData.Body getBody()
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
	
	public ReportRangeSensorData setAs(ReportRangeSensorData value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportRangeSensorData value)
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
	
	public boolean notEquals(ReportRangeSensorData value)
	{
		return !isEqual(value);
	}
	
	public ReportRangeSensorData()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportRangeSensorData(ReportRangeSensorData value)
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

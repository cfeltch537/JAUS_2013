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

public class ConfirmSensorConfiguration extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0801;
	
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
			
			public ConfirmSensorConfiguration.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0801;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0801;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ConfirmSensorConfiguration.AppHeader.HeaderRec getHeaderRec()
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
		
		public ConfirmSensorConfiguration.AppHeader assign(AppHeader value)
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
		public static class  ConfirmSensorConfigurationSequence
		{
			public static class  RequestIdRec
			{
			
				protected ConfirmSensorConfigurationSequence m_parent;
				protected short m_RequestID;
			
				public void setParent(ConfirmSensorConfigurationSequence parent)
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
				
				public short getRequestID()
				{
					return m_RequestID;
				}
				
				public void setRequestID(short value)
				{
					m_RequestID = value;
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
					
					bytes.put(pos, (byte) m_RequestID);
					pos += JausUtils.getNumBytes("byte");
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
					
					m_RequestID = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
				}
				
				public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.RequestIdRec assign(RequestIdRec value)
				{
					m_RequestID = value.m_RequestID;
					
					return this;
				}
				
				public boolean isEqual(RequestIdRec value)
				{
					if (m_RequestID != value.getRequestID())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RequestIdRec value)
				{
					return !this.isEqual(value);
				}
				
				public RequestIdRec()
				{
					m_parent = null;
					m_RequestID = 0;
				}
				
				public RequestIdRec(RequestIdRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RequestID = 0;
					
					/// Copy the values
					m_RequestID = value.m_RequestID;
				}
				
				public void finalize()
				{
				}
				
			}
			public static class  ConfirmSensorList
			{
				public static class  ConfirmSensorConfigurationVariant
				{
					public static class  SensorIdRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
							
							bytes.putShort(pos, (short) m_SensorID);
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
							
							m_SensorID = bytes.getShort(pos) & 0xffff;
							pos += JausUtils.getNumBytes("short");
						}
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.SensorIdRec assign(SensorIdRec value)
						{
							m_SensorID = value.m_SensorID;
							
							return this;
						}
						
						public boolean isEqual(SensorIdRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(SensorIdRec value)
						{
							return !this.isEqual(value);
						}
						
						public SensorIdRec()
						{
							m_parent = null;
							m_SensorID = 0;
						}
						
						public SensorIdRec(SensorIdRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  RangeSensorErrorRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
						protected short m_RangeSensorErrorCode;
						protected String m_ErrorMessage;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
						
						public short getRangeSensorErrorCode()
						{
							return m_RangeSensorErrorCode;
						}
						
						public void setRangeSensorErrorCode(short value)
						{
							if ((value == 3) || (value == 4) || (value == 5) || (value == 6) || (value == 255) || (value == 0) || (value == 1) || (value == 2))
							{
								m_RangeSensorErrorCode = value;
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
							bytes.put(pos, (byte) m_RangeSensorErrorCode);
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
							m_RangeSensorErrorCode = (short) (bytes.get(pos) & 0xff);
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
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.RangeSensorErrorRec assign(RangeSensorErrorRec value)
						{
							m_SensorID = value.m_SensorID;
							m_RangeSensorErrorCode = value.m_RangeSensorErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
							
							return this;
						}
						
						public boolean isEqual(RangeSensorErrorRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							if (m_RangeSensorErrorCode != value.getRangeSensorErrorCode())
							{
								return false;
							}
							if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(RangeSensorErrorRec value)
						{
							return !this.isEqual(value);
						}
						
						public RangeSensorErrorRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_RangeSensorErrorCode = 0;
							m_ErrorMessage = new String();
						}
						
						public RangeSensorErrorRec(RangeSensorErrorRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_RangeSensorErrorCode = 0;
							m_ErrorMessage = new String();
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_RangeSensorErrorCode = value.m_RangeSensorErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  VisualSensorErrorRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
						protected short m_VisualSensorErrorCode;
						protected String m_ErrorMessage;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
						
						public short getVisualSensorErrorCode()
						{
							return m_VisualSensorErrorCode;
						}
						
						public void setVisualSensorErrorCode(short value)
						{
							if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 4) || (value == 5) || (value == 6) || (value == 7) || (value == 8) || (value == 9) || (value == 10) || (value == 11) || (value == 12) || (value == 13) || (value == 14) || (value == 15) || (value == 16) || (value == 255))
							{
								m_VisualSensorErrorCode = value;
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
							bytes.put(pos, (byte) m_VisualSensorErrorCode);
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
							m_VisualSensorErrorCode = (short) (bytes.get(pos) & 0xff);
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
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.VisualSensorErrorRec assign(VisualSensorErrorRec value)
						{
							m_SensorID = value.m_SensorID;
							m_VisualSensorErrorCode = value.m_VisualSensorErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
							
							return this;
						}
						
						public boolean isEqual(VisualSensorErrorRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							if (m_VisualSensorErrorCode != value.getVisualSensorErrorCode())
							{
								return false;
							}
							if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(VisualSensorErrorRec value)
						{
							return !this.isEqual(value);
						}
						
						public VisualSensorErrorRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_VisualSensorErrorCode = 0;
							m_ErrorMessage = new String();
						}
						
						public VisualSensorErrorRec(VisualSensorErrorRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_VisualSensorErrorCode = 0;
							m_ErrorMessage = new String();
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_VisualSensorErrorCode = value.m_VisualSensorErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  DigitalVideoSensorErrorRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
						protected short m_DigitalVideoErrorCode;
						protected String m_ErrorMessage;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
						
						public short getDigitalVideoErrorCode()
						{
							return m_DigitalVideoErrorCode;
						}
						
						public void setDigitalVideoErrorCode(short value)
						{
							if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 4) || (value == 5) || (value == 6) || (value == 7) || (value == 255))
							{
								m_DigitalVideoErrorCode = value;
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
							bytes.put(pos, (byte) m_DigitalVideoErrorCode);
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
							m_DigitalVideoErrorCode = (short) (bytes.get(pos) & 0xff);
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
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.DigitalVideoSensorErrorRec assign(DigitalVideoSensorErrorRec value)
						{
							m_SensorID = value.m_SensorID;
							m_DigitalVideoErrorCode = value.m_DigitalVideoErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
							
							return this;
						}
						
						public boolean isEqual(DigitalVideoSensorErrorRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							if (m_DigitalVideoErrorCode != value.getDigitalVideoErrorCode())
							{
								return false;
							}
							if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(DigitalVideoSensorErrorRec value)
						{
							return !this.isEqual(value);
						}
						
						public DigitalVideoSensorErrorRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_DigitalVideoErrorCode = 0;
							m_ErrorMessage = new String();
						}
						
						public DigitalVideoSensorErrorRec(DigitalVideoSensorErrorRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_DigitalVideoErrorCode = 0;
							m_ErrorMessage = new String();
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_DigitalVideoErrorCode = value.m_DigitalVideoErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  AnalogVideoSensorErrorRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
						protected short m_AnalogVideoErrorCode;
						protected String m_ErrorMessage;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
						
						public short getAnalogVideoErrorCode()
						{
							return m_AnalogVideoErrorCode;
						}
						
						public void setAnalogVideoErrorCode(short value)
						{
							if ((value == 0) || (value == 1) || (value == 255))
							{
								m_AnalogVideoErrorCode = value;
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
							bytes.put(pos, (byte) m_AnalogVideoErrorCode);
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
							m_AnalogVideoErrorCode = (short) (bytes.get(pos) & 0xff);
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
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.AnalogVideoSensorErrorRec assign(AnalogVideoSensorErrorRec value)
						{
							m_SensorID = value.m_SensorID;
							m_AnalogVideoErrorCode = value.m_AnalogVideoErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
							
							return this;
						}
						
						public boolean isEqual(AnalogVideoSensorErrorRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							if (m_AnalogVideoErrorCode != value.getAnalogVideoErrorCode())
							{
								return false;
							}
							if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(AnalogVideoSensorErrorRec value)
						{
							return !this.isEqual(value);
						}
						
						public AnalogVideoSensorErrorRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_AnalogVideoErrorCode = 0;
							m_ErrorMessage = new String();
						}
						
						public AnalogVideoSensorErrorRec(AnalogVideoSensorErrorRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_AnalogVideoErrorCode = 0;
							m_ErrorMessage = new String();
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_AnalogVideoErrorCode = value.m_AnalogVideoErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  StillImageSensorErrorRec
					{
					
						protected ConfirmSensorConfigurationVariant m_parent;
						protected int m_SensorID;
						protected short m_StillImageErrorCode;
						protected String m_ErrorMessage;
					
						public void setParent(ConfirmSensorConfigurationVariant parent)
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
						
						public short getStillImageErrorCode()
						{
							return m_StillImageErrorCode;
						}
						
						public void setStillImageErrorCode(short value)
						{
							if ((value == 0) || (value == 1) || (value == 2) || (value == 3) || (value == 255))
							{
								m_StillImageErrorCode = value;
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
							bytes.put(pos, (byte) m_StillImageErrorCode);
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
							m_StillImageErrorCode = (short) (bytes.get(pos) & 0xff);
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
						
						public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.StillImageSensorErrorRec assign(StillImageSensorErrorRec value)
						{
							m_SensorID = value.m_SensorID;
							m_StillImageErrorCode = value.m_StillImageErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
							
							return this;
						}
						
						public boolean isEqual(StillImageSensorErrorRec value)
						{
							if (m_SensorID != value.getSensorID())
							{
								return false;
							}
							if (m_StillImageErrorCode != value.getStillImageErrorCode())
							{
								return false;
							}
							if ((m_ErrorMessage.length() != value.m_ErrorMessage.length()) || (m_ErrorMessage.compareTo(value.m_ErrorMessage) != 0))
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(StillImageSensorErrorRec value)
						{
							return !this.isEqual(value);
						}
						
						public StillImageSensorErrorRec()
						{
							m_parent = null;
							m_SensorID = 0;
							m_StillImageErrorCode = 0;
							m_ErrorMessage = new String();
						}
						
						public StillImageSensorErrorRec(StillImageSensorErrorRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_SensorID = 0;
							m_StillImageErrorCode = 0;
							m_ErrorMessage = new String();
							
							/// Copy the values
							m_SensorID = value.m_SensorID;
							m_StillImageErrorCode = value.m_StillImageErrorCode;
							m_ErrorMessage = value.m_ErrorMessage;
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected ConfirmSensorList m_parent;
					protected short m_FieldValue;
					protected SensorIdRec m_SensorIdRec;
					protected RangeSensorErrorRec m_RangeSensorErrorRec;
					protected VisualSensorErrorRec m_VisualSensorErrorRec;
					protected DigitalVideoSensorErrorRec m_DigitalVideoSensorErrorRec;
					protected AnalogVideoSensorErrorRec m_AnalogVideoSensorErrorRec;
					protected StillImageSensorErrorRec m_StillImageSensorErrorRec;
				
					public void setParent(ConfirmSensorList parent)
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
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.SensorIdRec getSensorIdRec()
					{
						return m_SensorIdRec;
					}
					
					public void setSensorIdRec(SensorIdRec value)
					{
						m_SensorIdRec = value;
						setParentPresenceVector();
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.RangeSensorErrorRec getRangeSensorErrorRec()
					{
						return m_RangeSensorErrorRec;
					}
					
					public void setRangeSensorErrorRec(RangeSensorErrorRec value)
					{
						m_RangeSensorErrorRec = value;
						setParentPresenceVector();
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.VisualSensorErrorRec getVisualSensorErrorRec()
					{
						return m_VisualSensorErrorRec;
					}
					
					public void setVisualSensorErrorRec(VisualSensorErrorRec value)
					{
						m_VisualSensorErrorRec = value;
						setParentPresenceVector();
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.DigitalVideoSensorErrorRec getDigitalVideoSensorErrorRec()
					{
						return m_DigitalVideoSensorErrorRec;
					}
					
					public void setDigitalVideoSensorErrorRec(DigitalVideoSensorErrorRec value)
					{
						m_DigitalVideoSensorErrorRec = value;
						setParentPresenceVector();
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.AnalogVideoSensorErrorRec getAnalogVideoSensorErrorRec()
					{
						return m_AnalogVideoSensorErrorRec;
					}
					
					public void setAnalogVideoSensorErrorRec(AnalogVideoSensorErrorRec value)
					{
						m_AnalogVideoSensorErrorRec = value;
						setParentPresenceVector();
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant.StillImageSensorErrorRec getStillImageSensorErrorRec()
					{
						return m_StillImageSensorErrorRec;
					}
					
					public void setStillImageSensorErrorRec(StillImageSensorErrorRec value)
					{
						m_StillImageSensorErrorRec = value;
						setParentPresenceVector();
					}
					
					public short getFieldValue()
					{
						return m_FieldValue;
					}
					
					public void setFieldValue(short fieldValue)
					{
						if(fieldValue > 5)
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
								size += m_SensorIdRec.getSize();
								break;
							case 1:
								size += m_RangeSensorErrorRec.getSize();
								break;
							case 2:
								size += m_VisualSensorErrorRec.getSize();
								break;
							case 3:
								size += m_DigitalVideoSensorErrorRec.getSize();
								break;
							case 4:
								size += m_AnalogVideoSensorErrorRec.getSize();
								break;
							case 5:
								size += m_StillImageSensorErrorRec.getSize();
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
								m_SensorIdRec.encode(bytes, pos);
								pos += m_SensorIdRec.getSize();
								break;
							case 1:
								m_RangeSensorErrorRec.encode(bytes, pos);
								pos += m_RangeSensorErrorRec.getSize();
								break;
							case 2:
								m_VisualSensorErrorRec.encode(bytes, pos);
								pos += m_VisualSensorErrorRec.getSize();
								break;
							case 3:
								m_DigitalVideoSensorErrorRec.encode(bytes, pos);
								pos += m_DigitalVideoSensorErrorRec.getSize();
								break;
							case 4:
								m_AnalogVideoSensorErrorRec.encode(bytes, pos);
								pos += m_AnalogVideoSensorErrorRec.getSize();
								break;
							case 5:
								m_StillImageSensorErrorRec.encode(bytes, pos);
								pos += m_StillImageSensorErrorRec.getSize();
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
								m_SensorIdRec.decode(bytes, pos);
								pos += m_SensorIdRec.getSize();
								break;
							case 1:
								m_RangeSensorErrorRec.decode(bytes, pos);
								pos += m_RangeSensorErrorRec.getSize();
								break;
							case 2:
								m_VisualSensorErrorRec.decode(bytes, pos);
								pos += m_VisualSensorErrorRec.getSize();
								break;
							case 3:
								m_DigitalVideoSensorErrorRec.decode(bytes, pos);
								pos += m_DigitalVideoSensorErrorRec.getSize();
								break;
							case 4:
								m_AnalogVideoSensorErrorRec.decode(bytes, pos);
								pos += m_AnalogVideoSensorErrorRec.getSize();
								break;
							case 5:
								m_StillImageSensorErrorRec.decode(bytes, pos);
								pos += m_StillImageSensorErrorRec.getSize();
								break;
						}
					}
					
					public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant assign(ConfirmSensorConfigurationVariant value)
					{
						m_FieldValue = value.m_FieldValue;
						m_SensorIdRec = value.m_SensorIdRec;
						m_SensorIdRec.setParent(this);
						m_RangeSensorErrorRec = value.m_RangeSensorErrorRec;
						m_RangeSensorErrorRec.setParent(this);
						m_VisualSensorErrorRec = value.m_VisualSensorErrorRec;
						m_VisualSensorErrorRec.setParent(this);
						m_DigitalVideoSensorErrorRec = value.m_DigitalVideoSensorErrorRec;
						m_DigitalVideoSensorErrorRec.setParent(this);
						m_AnalogVideoSensorErrorRec = value.m_AnalogVideoSensorErrorRec;
						m_AnalogVideoSensorErrorRec.setParent(this);
						m_StillImageSensorErrorRec = value.m_StillImageSensorErrorRec;
						m_StillImageSensorErrorRec.setParent(this);
						
						return this;
					}
					
					public boolean isEqual(ConfirmSensorConfigurationVariant value)
					{
						if (m_FieldValue != value.m_FieldValue)
						{
							return false;
						}
						if (!m_SensorIdRec.isEqual(value.getSensorIdRec()))
						{
							return false;
						}
						if (!m_RangeSensorErrorRec.isEqual(value.getRangeSensorErrorRec()))
						{
							return false;
						}
						if (!m_VisualSensorErrorRec.isEqual(value.getVisualSensorErrorRec()))
						{
							return false;
						}
						if (!m_DigitalVideoSensorErrorRec.isEqual(value.getDigitalVideoSensorErrorRec()))
						{
							return false;
						}
						if (!m_AnalogVideoSensorErrorRec.isEqual(value.getAnalogVideoSensorErrorRec()))
						{
							return false;
						}
						if (!m_StillImageSensorErrorRec.isEqual(value.getStillImageSensorErrorRec()))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(ConfirmSensorConfigurationVariant value)
					{
						return !this.isEqual(value);
					}
					
					public ConfirmSensorConfigurationVariant()
					{
						m_parent = null;
						m_SensorIdRec = new SensorIdRec();
						m_SensorIdRec.setParent(this);
						m_RangeSensorErrorRec = new RangeSensorErrorRec();
						m_RangeSensorErrorRec.setParent(this);
						m_VisualSensorErrorRec = new VisualSensorErrorRec();
						m_VisualSensorErrorRec.setParent(this);
						m_DigitalVideoSensorErrorRec = new DigitalVideoSensorErrorRec();
						m_DigitalVideoSensorErrorRec.setParent(this);
						m_AnalogVideoSensorErrorRec = new AnalogVideoSensorErrorRec();
						m_AnalogVideoSensorErrorRec.setParent(this);
						m_StillImageSensorErrorRec = new StillImageSensorErrorRec();
						m_StillImageSensorErrorRec.setParent(this);
					}
					
					public ConfirmSensorConfigurationVariant(ConfirmSensorConfigurationVariant value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_SensorIdRec = new SensorIdRec();
						m_SensorIdRec.setParent(this);
						m_RangeSensorErrorRec = new RangeSensorErrorRec();
						m_RangeSensorErrorRec.setParent(this);
						m_VisualSensorErrorRec = new VisualSensorErrorRec();
						m_VisualSensorErrorRec.setParent(this);
						m_DigitalVideoSensorErrorRec = new DigitalVideoSensorErrorRec();
						m_DigitalVideoSensorErrorRec.setParent(this);
						m_AnalogVideoSensorErrorRec = new AnalogVideoSensorErrorRec();
						m_AnalogVideoSensorErrorRec.setParent(this);
						m_StillImageSensorErrorRec = new StillImageSensorErrorRec();
						m_StillImageSensorErrorRec.setParent(this);
						
						/// Copy the values
						m_FieldValue = value.m_FieldValue;
						m_SensorIdRec = value.m_SensorIdRec;
						m_SensorIdRec.setParent(this);
						m_RangeSensorErrorRec = value.m_RangeSensorErrorRec;
						m_RangeSensorErrorRec.setParent(this);
						m_VisualSensorErrorRec = value.m_VisualSensorErrorRec;
						m_VisualSensorErrorRec.setParent(this);
						m_DigitalVideoSensorErrorRec = value.m_DigitalVideoSensorErrorRec;
						m_DigitalVideoSensorErrorRec.setParent(this);
						m_AnalogVideoSensorErrorRec = value.m_AnalogVideoSensorErrorRec;
						m_AnalogVideoSensorErrorRec.setParent(this);
						m_StillImageSensorErrorRec = value.m_StillImageSensorErrorRec;
						m_StillImageSensorErrorRec.setParent(this);
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected ConfirmSensorConfigurationSequence m_parent;
				protected ArrayList<ConfirmSensorConfigurationVariant> m_ConfirmSensorConfigurationVariant;
			
				public void setParent(ConfirmSensorConfigurationSequence parent)
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
					return (long) m_ConfirmSensorConfigurationVariant.size();
				}
				
				public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList.ConfirmSensorConfigurationVariant getElement(int index)
				{
					return m_ConfirmSensorConfigurationVariant.get(index);
				}
				
				public void setElement(int index, ConfirmSensorConfigurationVariant value)
				{
					if(m_ConfirmSensorConfigurationVariant.size()-1 < index)
					{
						return;
					}
					
					m_ConfirmSensorConfigurationVariant.get(index).assign(value);
					m_ConfirmSensorConfigurationVariant.get(index).setParent(this);
					setParentPresenceVector();
				}
				
				public void addElement(ConfirmSensorConfigurationVariant value)
				{
					m_ConfirmSensorConfigurationVariant.add(value);
					m_ConfirmSensorConfigurationVariant.get(m_ConfirmSensorConfigurationVariant.size()-1).setParent(this);
					setParentPresenceVector();
				}
				
				public void deleteElement(int index)
				{
					if(m_ConfirmSensorConfigurationVariant.size()-1 < index)
					{
						return;
					}
					
					m_ConfirmSensorConfigurationVariant.remove(index);
				}
				
				public void  deleteLastElement()
				{
					m_ConfirmSensorConfigurationVariant.remove(m_ConfirmSensorConfigurationVariant.size() -1);
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
					for (int i = 0; i < m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						size += m_ConfirmSensorConfigurationVariant.get(i).getSize();
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
					
					int size = (int) m_ConfirmSensorConfigurationVariant.size();
					bytes.putShort(pos, (short) size);
					pos += JausUtils.getNumBytes("short");
					for (int i = 0; i < m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						m_ConfirmSensorConfigurationVariant.get(i).encode(bytes, pos);
						pos += m_ConfirmSensorConfigurationVariant.get(i).getSize();
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
					m_ConfirmSensorConfigurationVariant = new ArrayList<ConfirmSensorConfigurationVariant>();
					for (int i = 0; i < size; i++)
					{
						m_ConfirmSensorConfigurationVariant.add(new ConfirmSensorConfigurationVariant());
						m_ConfirmSensorConfigurationVariant.get(i).decode(bytes, pos);
						pos += m_ConfirmSensorConfigurationVariant.get(i).getSize();
					}
				}
				
				public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList assign(ConfirmSensorList value)
				{
					m_ConfirmSensorConfigurationVariant.clear();
					
					for (int i = 0; i < value.m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						m_ConfirmSensorConfigurationVariant.add(value.m_ConfirmSensorConfigurationVariant.get(i));
						m_ConfirmSensorConfigurationVariant.get(i).setParent(this);
					}
					
					return this;
				}
				
				public boolean isEqual(ConfirmSensorList value)
				{
					for (int i = 0; i < m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						if (m_ConfirmSensorConfigurationVariant.get(i) != value.m_ConfirmSensorConfigurationVariant.get(i))
						{
							return false;
						}
					}
					
					return true;
				}
				
				public boolean notEquals(ConfirmSensorList value)
				{
					return !this.isEqual(value);
				}
				
				public ConfirmSensorList()
				{
					m_parent = null;
					m_ConfirmSensorConfigurationVariant = new ArrayList<ConfirmSensorConfigurationVariant>();
					for (int i = 0; i < m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						m_ConfirmSensorConfigurationVariant.get(i).setParent(this);
					}
				}
				
				public ConfirmSensorList(ConfirmSensorList value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_ConfirmSensorConfigurationVariant = new ArrayList<ConfirmSensorConfigurationVariant>();
					for (int i = 0; i < m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						m_ConfirmSensorConfigurationVariant.get(i).setParent(this);
					}
					
					/// Copy the values
					m_ConfirmSensorConfigurationVariant.clear();
					
					for (int i = 0; i < value.m_ConfirmSensorConfigurationVariant.size(); i++)
					{
						m_ConfirmSensorConfigurationVariant.add(value.m_ConfirmSensorConfigurationVariant.get(i));
						m_ConfirmSensorConfigurationVariant.get(i).setParent(this);
					}
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected RequestIdRec m_RequestIdRec;
			protected ConfirmSensorList m_ConfirmSensorList;
		
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
			
			public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.RequestIdRec getRequestIdRec()
			{
				return m_RequestIdRec;
			}
			
			public void setRequestIdRec(RequestIdRec value)
			{
				m_RequestIdRec = value;
				setParentPresenceVector();
			}
			
			public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence.ConfirmSensorList getConfirmSensorList()
			{
				return m_ConfirmSensorList;
			}
			
			public void setConfirmSensorList(ConfirmSensorList value)
			{
				m_ConfirmSensorList = value;
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
				
				size += m_RequestIdRec.getSize();
				size += m_ConfirmSensorList.getSize();
				
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
				
				m_RequestIdRec.encode(bytes, pos);
				pos += m_RequestIdRec.getSize();
				m_ConfirmSensorList.encode(bytes, pos);
				pos += m_ConfirmSensorList.getSize();
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
				
				m_RequestIdRec.decode(bytes, pos);
				pos += m_RequestIdRec.getSize();
				m_ConfirmSensorList.decode(bytes, pos);
				pos += m_ConfirmSensorList.getSize();
			}
			
			public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence assign(ConfirmSensorConfigurationSequence value)
			{
				m_RequestIdRec = value.m_RequestIdRec;
				m_RequestIdRec.setParent(this);
				m_RequestIdRec = value.m_RequestIdRec;
				m_ConfirmSensorList = value.m_ConfirmSensorList;
				m_ConfirmSensorList.setParent(this);
				m_ConfirmSensorList = value.m_ConfirmSensorList;
				
				return this;
			}
			
			public boolean isEqual(ConfirmSensorConfigurationSequence value)
			{
				if (!m_RequestIdRec.isEqual(value.getRequestIdRec()))
				{
					return false;
				}
				
				if (!m_RequestIdRec.isEqual(value.getRequestIdRec()))
				{
					return false;
				}
				if (!m_ConfirmSensorList.isEqual(value.m_ConfirmSensorList))
				{
					return false;
				}
				
				if (!m_ConfirmSensorList.isEqual(value.getConfirmSensorList()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ConfirmSensorConfigurationSequence value)
			{
				return !this.isEqual(value);
			}
			
			public ConfirmSensorConfigurationSequence()
			{
				m_parent = null;
				m_RequestIdRec = new RequestIdRec();
				m_RequestIdRec.setParent(this);
				m_ConfirmSensorList = new ConfirmSensorList();
				m_ConfirmSensorList.setParent(this);
			}
			
			public ConfirmSensorConfigurationSequence(ConfirmSensorConfigurationSequence value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RequestIdRec = new RequestIdRec();
				m_RequestIdRec.setParent(this);
				m_ConfirmSensorList = new ConfirmSensorList();
				m_ConfirmSensorList.setParent(this);
				
				/// Copy the values
				m_RequestIdRec = value.m_RequestIdRec;
				m_RequestIdRec.setParent(this);
				m_RequestIdRec = value.m_RequestIdRec;
				m_ConfirmSensorList = value.m_ConfirmSensorList;
				m_ConfirmSensorList.setParent(this);
				m_ConfirmSensorList = value.m_ConfirmSensorList;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ConfirmSensorConfigurationSequence m_ConfirmSensorConfigurationSequence;
	
		public ConfirmSensorConfiguration.Body.ConfirmSensorConfigurationSequence getConfirmSensorConfigurationSequence()
		{
			return m_ConfirmSensorConfigurationSequence;
		}
		
		public int setConfirmSensorConfigurationSequence(ConfirmSensorConfigurationSequence value)
		{
			m_ConfirmSensorConfigurationSequence = value;
			setParentPresenceVector();
			return 0;
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
			
			size += m_ConfirmSensorConfigurationSequence.getSize();
			
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
			
			m_ConfirmSensorConfigurationSequence.encode(bytes, pos);
			pos += m_ConfirmSensorConfigurationSequence.getSize();
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
			
			m_ConfirmSensorConfigurationSequence.decode(bytes, pos);
			pos += m_ConfirmSensorConfigurationSequence.getSize();
		}
		
		public ConfirmSensorConfiguration.Body assign(Body value)
		{
			m_ConfirmSensorConfigurationSequence = value.m_ConfirmSensorConfigurationSequence;
			m_ConfirmSensorConfigurationSequence.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ConfirmSensorConfigurationSequence.isEqual(value.getConfirmSensorConfigurationSequence()))
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
			m_ConfirmSensorConfigurationSequence = new ConfirmSensorConfigurationSequence();
			m_ConfirmSensorConfigurationSequence.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ConfirmSensorConfigurationSequence = new ConfirmSensorConfigurationSequence();
			m_ConfirmSensorConfigurationSequence.setParent(this);
			
			/// Copy the values
			m_ConfirmSensorConfigurationSequence = value.m_ConfirmSensorConfigurationSequence;
			m_ConfirmSensorConfigurationSequence.setParent(this);
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
	public ConfirmSensorConfiguration.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ConfirmSensorConfiguration.Body getBody()
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
	
	public ConfirmSensorConfiguration setAs(ConfirmSensorConfiguration value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ConfirmSensorConfiguration value)
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
	
	public boolean notEquals(ConfirmSensorConfiguration value)
	{
		return !isEqual(value);
	}
	
	public ConfirmSensorConfiguration()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ConfirmSensorConfiguration(ConfirmSensorConfiguration value)
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

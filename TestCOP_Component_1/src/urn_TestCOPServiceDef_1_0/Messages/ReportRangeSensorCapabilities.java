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

public class ReportRangeSensorCapabilities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4801;
	
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
			
			public ReportRangeSensorCapabilities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4801;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4801;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportRangeSensorCapabilities.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportRangeSensorCapabilities.AppHeader assign(AppHeader value)
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
		public static class  RangeSensorCapabilitiesList
		{
			public static class  RangeSensorCapabilitiesRec
			{
				public static class  SupportedStates
				{
				
					protected RangeSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(RangeSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(0);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getActive()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setActive(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getStandby()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setStandby(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getOff()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setOff(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec.SupportedStates assign(SupportedStates value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(SupportedStates value)
					{
						return this.m_SubFields == value.getOff();
					}
					
					public boolean notEquals(SupportedStates value)
					{
						return !this.isEqual(value);
					}
					
					public SupportedStates()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public SupportedStates(SupportedStates value)
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
				public static class  SupportedCompression
				{
				
					protected RangeSensorCapabilitiesRec m_parent;
					protected short m_SubFields;
				
					public void setParent(RangeSensorCapabilitiesRec parent)
					{
						m_parent = parent;
					}
					
					public void setParentPresenceVector()
					{
						if(m_parent != null )
						{
							m_parent.setPresenceVector(9);
							m_parent.setParentPresenceVector();
						}
					}
					
					public short getNoCompression()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 0; index <= 0; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setNoCompression(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 0; index <= 0; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getDEFLATE()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 1; index <= 1; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setDEFLATE(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 1; index <= 1; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getBzip2()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 2; index <= 2; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setBzip2(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 2; index <= 2; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public short getLZMA()
					{
						BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
						BitSet subFieldBitSet = new BitSet(1);
						int i = 0;
						
						for (int index = 3; index <= 3; index++)
						{
						    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
						}
						
						return (short)JausUtils.getPVLong(subFieldBitSet);
					}
					
					public int setLZMA(short value)
					{
						if ((value == 0) || (value == 1))
						{
							BitSet bfbs = JausUtils.setPV(m_SubFields);
							BitSet sfbs = new BitSet(1);
							sfbs = JausUtils.setPV(value);
							int i = 0;
							
							for (int index = 3; index <= 3; index++)
							{
								bfbs.set(index, sfbs.get(i++));
							}
							
							m_SubFields = (short) JausUtils.getPVLong(bfbs);
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
						
						
						bytes.put(pos, (byte) m_SubFields);
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
						
						m_SubFields = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
					
					public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec.SupportedCompression assign(SupportedCompression value)
					{
						this.m_SubFields = value.m_SubFields;
						
						return this;
					}
					
					public boolean isEqual(SupportedCompression value)
					{
						return this.m_SubFields == value.getLZMA();
					}
					
					public boolean notEquals(SupportedCompression value)
					{
						return !this.isEqual(value);
					}
					
					public SupportedCompression()
					{
						m_parent = null;
						m_SubFields = 0;
					}
					
					public SupportedCompression(SupportedCompression value)
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
			
			
				protected RangeSensorCapabilitiesList m_parent;
				protected BitSet m_PresenceVector;
				protected int m_PresenceVectorTemp;
				protected int m_SensorID;
				protected String m_SensorName;
				protected SupportedStates m_SupportedStates;
				protected long m_MinimumHorizontalFieldOfViewStartAngle;
				protected long m_MaximumHorizontalFieldOfViewStopAngle;
				protected long m_MinimumVerticalFieldOfViewStartAngle;
				protected long m_MaximumVerticalFieldOfViewStopAngle;
				protected int m_MiniumumUpdateRate;
				protected int m_MaximumUpdateRate;
				protected long m_MinimumRange;
				protected long m_MaximumRange;
				protected SupportedCompression m_SupportedCompression;
				protected short m_CoordinateTransformationSupported;
			
				public void setParent(RangeSensorCapabilitiesList parent)
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
				
				public int getPresenceVector()
				{
					return m_PresenceVectorTemp;
				}
				
				protected void setPresenceVector(int index)
				{
					
					m_PresenceVector.set(index);
					m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
				}
				
				public boolean checkPresenceVector(int index)
				{
					
					return m_PresenceVector.get(index);
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
				
				public String getSensorName()
				{
					return m_SensorName;
				}
				
				public void setSensorName(String value)
				{
					if ( value.length() > 255)
					{
						return;
					}
					
					m_SensorName = value;
					if (m_SensorName.length() < 0)
					{
						m_SensorName = m_SensorName.substring(0, 0);
					}
					setParentPresenceVector();
				}
				
				public boolean isSupportedStatesValid()
				{
					if (checkPresenceVector(0))
					{
						return true;
					}
					return false;
				}
				
				public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec.SupportedStates getSupportedStates()
				{
					return m_SupportedStates;
				}
				
				public void setSupportedStates(SupportedStates value)
				{
					m_SupportedStates = value;
					setPresenceVector(0);
					setParentPresenceVector();
				}
				
				public boolean isMinimumHorizontalFieldOfViewStartAngleValid()
				{
					if (checkPresenceVector(1))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumHorizontalFieldOfViewStartAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_MinimumHorizontalFieldOfViewStartAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumHorizontalFieldOfViewStartAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_MinimumHorizontalFieldOfViewStartAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(1);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumHorizontalFieldOfViewStopAngleValid()
				{
					if (checkPresenceVector(2))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumHorizontalFieldOfViewStopAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_MaximumHorizontalFieldOfViewStopAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumHorizontalFieldOfViewStopAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_MaximumHorizontalFieldOfViewStopAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(2);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMinimumVerticalFieldOfViewStartAngleValid()
				{
					if (checkPresenceVector(3))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumVerticalFieldOfViewStartAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_MinimumVerticalFieldOfViewStartAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumVerticalFieldOfViewStartAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_MinimumVerticalFieldOfViewStartAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(3);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumVerticalFieldOfViewStopAngleValid()
				{
					if (checkPresenceVector(4))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumVerticalFieldOfViewStopAngle()
				{
					double value;
					
					double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
					double bias = -3.141592653589793;
					
					value = m_MaximumVerticalFieldOfViewStopAngle * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumVerticalFieldOfViewStopAngle(double value)
				{
					if ((value >= -3.141592653589793) && (value <= 3.141592653589793))
					{
						double scaleFactor = ( 3.141592653589793 - -3.141592653589793 ) / 4.294967295E9;
						double bias = -3.141592653589793;
						
						m_MaximumVerticalFieldOfViewStopAngle= (long)((value - bias) / scaleFactor);
						setPresenceVector(4);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMiniumumUpdateRateValid()
				{
					if (checkPresenceVector(5))
					{
						return true;
					}
					return false;
				}
				
				public double getMiniumumUpdateRate()
				{
					double value;
					
					double scaleFactor = ( 1000 - 0 ) / 65535.0;
					double bias = 0;
					
					value = m_MiniumumUpdateRate * scaleFactor + bias;
					
					return value;
				}
				
				public void setMiniumumUpdateRate(double value)
				{
					if ((value >= 0) && (value <= 1000))
					{
						double scaleFactor = ( 1000 - 0 ) / 65535.0;
						double bias = 0;
						
						m_MiniumumUpdateRate= (int)((value - bias) / scaleFactor);
						setPresenceVector(5);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumUpdateRateValid()
				{
					if (checkPresenceVector(6))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumUpdateRate()
				{
					double value;
					
					double scaleFactor = ( 1000 - 0 ) / 65535.0;
					double bias = 0;
					
					value = m_MaximumUpdateRate * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumUpdateRate(double value)
				{
					if ((value >= 0) && (value <= 1000))
					{
						double scaleFactor = ( 1000 - 0 ) / 65535.0;
						double bias = 0;
						
						m_MaximumUpdateRate= (int)((value - bias) / scaleFactor);
						setPresenceVector(6);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMinimumRangeValid()
				{
					if (checkPresenceVector(7))
					{
						return true;
					}
					return false;
				}
				
				public double getMinimumRange()
				{
					double value;
					
					double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					value = m_MinimumRange * scaleFactor + bias;
					
					return value;
				}
				
				public void setMinimumRange(double value)
				{
					if ((value >= 0) && (value <= 1000000.0))
					{
						double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						m_MinimumRange= (long)((value - bias) / scaleFactor);
						setPresenceVector(7);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isMaximumRangeValid()
				{
					if (checkPresenceVector(8))
					{
						return true;
					}
					return false;
				}
				
				public double getMaximumRange()
				{
					double value;
					
					double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					value = m_MaximumRange * scaleFactor + bias;
					
					return value;
				}
				
				public void setMaximumRange(double value)
				{
					if ((value >= 0) && (value <= 1000000.0))
					{
						double scaleFactor = ( 1000000.0 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						m_MaximumRange= (long)((value - bias) / scaleFactor);
						setPresenceVector(8);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isSupportedCompressionValid()
				{
					if (checkPresenceVector(9))
					{
						return true;
					}
					return false;
				}
				
				public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec.SupportedCompression getSupportedCompression()
				{
					return m_SupportedCompression;
				}
				
				public void setSupportedCompression(SupportedCompression value)
				{
					m_SupportedCompression = value;
					setPresenceVector(9);
					setParentPresenceVector();
				}
				
				public boolean isCoordinateTransformationSupportedValid()
				{
					if (checkPresenceVector(10))
					{
						return true;
					}
					return false;
				}
				
				public short getCoordinateTransformationSupported()
				{
					return m_CoordinateTransformationSupported;
				}
				
				public void setCoordinateTransformationSupported(short value)
				{
					if ((value == 0) || (value == 1))
					{
						m_CoordinateTransformationSupported = value;
						setPresenceVector(10);
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
					
					size += JausUtils.getNumBytes("short");
					size += JausUtils.getNumBytes("short");
					size += JausUtils.getNumBytes("byte");
					size += m_SensorName.length();
					if (checkPresenceVector(0))
					{
						size += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(6))
					{
						size += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(7))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(8))
					{
						size += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(9))
					{
						size += m_SupportedCompression.getSize();
					}
					if (checkPresenceVector(10))
					{
						size += JausUtils.getNumBytes("byte");
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
						int m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
					bytes.putShort(pos, (short) m_PresenceVectorTemp);
					pos += JausUtils.getNumBytes("short");
					}
					catch(Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					bytes.putShort(pos, (short) m_SensorID);
					pos += JausUtils.getNumBytes("short");
					
					try
					{
					bytes.put(pos, (byte) m_SensorName.length());
					pos += JausUtils.getNumBytes("byte");
					
					char[] m_SensorNameBytes = m_SensorName.toCharArray();
					for(int str_pos = 0; str_pos<m_SensorNameBytes.length; str_pos++)
					{
						bytes.put(pos, (byte) m_SensorNameBytes[str_pos]);
						pos++;
					}
					}
					catch (Exception e)
					{
						
					}
					if (checkPresenceVector(0))
					{
						m_SupportedStates.encode(bytes, pos);
						pos += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						bytes.putInt(pos, (int) m_MinimumHorizontalFieldOfViewStartAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						bytes.putInt(pos, (int) m_MaximumHorizontalFieldOfViewStopAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						bytes.putInt(pos, (int) m_MinimumVerticalFieldOfViewStartAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						bytes.putInt(pos, (int) m_MaximumVerticalFieldOfViewStopAngle);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						bytes.putShort(pos, (short) m_MiniumumUpdateRate);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(6))
					{
						bytes.putShort(pos, (short) m_MaximumUpdateRate);
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(7))
					{
						bytes.putInt(pos, (int) m_MinimumRange);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(8))
					{
						bytes.putInt(pos, (int) m_MaximumRange);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(9))
					{
						m_SupportedCompression.encode(bytes, pos);
						pos += m_SupportedCompression.getSize();
					}
					if (checkPresenceVector(10))
					{
						bytes.put(pos, (byte) m_CoordinateTransformationSupported);
						pos += JausUtils.getNumBytes("byte");
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
						int m_PresenceVectorTemp = 0;
					m_PresenceVectorTemp = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
					}
					catch(Exception e)
					{
						logger.log(Level.SEVERE, null, e);
					}
					m_SensorID = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
					
					short m_SensorNameLength = 0;
					m_SensorNameLength = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					
					
					// Decoding the string m_SensorNamefrom the buffer.
					char[] m_SensorNameBytes = new char[(int)m_SensorNameLength];
					for(int decode_pos = 0; decode_pos<(int)m_SensorNameLength;decode_pos++)
					{
						m_SensorNameBytes[decode_pos] = (char) (bytes.get(pos) &0xff);
						pos++;
					}
					m_SensorName = new String(m_SensorNameBytes);
					if (checkPresenceVector(0))
					{
						m_SupportedStates.decode(bytes, pos);
						pos += m_SupportedStates.getSize();
					}
					if (checkPresenceVector(1))
					{
						m_MinimumHorizontalFieldOfViewStartAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						m_MaximumHorizontalFieldOfViewStopAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(3))
					{
						m_MinimumVerticalFieldOfViewStartAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(4))
					{
						m_MaximumVerticalFieldOfViewStopAngle = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(5))
					{
						m_MiniumumUpdateRate = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(6))
					{
						m_MaximumUpdateRate = bytes.getShort(pos) & 0xffff;
						pos += JausUtils.getNumBytes("short");
					}
					if (checkPresenceVector(7))
					{
						m_MinimumRange = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(8))
					{
						m_MaximumRange = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(9))
					{
						m_SupportedCompression.decode(bytes, pos);
						pos += m_SupportedCompression.getSize();
					}
					if (checkPresenceVector(10))
					{
						m_CoordinateTransformationSupported = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
					}
				}
				
				public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec assign(RangeSensorCapabilitiesRec value)
				{
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorName = value.m_SensorName;
					m_SupportedStates = value.m_SupportedStates;
					m_MinimumHorizontalFieldOfViewStartAngle = value.m_MinimumHorizontalFieldOfViewStartAngle;
					m_MaximumHorizontalFieldOfViewStopAngle = value.m_MaximumHorizontalFieldOfViewStopAngle;
					m_MinimumVerticalFieldOfViewStartAngle = value.m_MinimumVerticalFieldOfViewStartAngle;
					m_MaximumVerticalFieldOfViewStopAngle = value.m_MaximumVerticalFieldOfViewStopAngle;
					m_MiniumumUpdateRate = value.m_MiniumumUpdateRate;
					m_MaximumUpdateRate = value.m_MaximumUpdateRate;
					m_MinimumRange = value.m_MinimumRange;
					m_MaximumRange = value.m_MaximumRange;
					m_SupportedCompression = value.m_SupportedCompression;
					m_CoordinateTransformationSupported = value.m_CoordinateTransformationSupported;
					
					return this;
				}
				
				public boolean isEqual(RangeSensorCapabilitiesRec value)
				{
					if (!m_PresenceVector.equals(value.m_PresenceVector))
					{
						return false;
					}
					if (m_SensorID != value.getSensorID())
					{
						return false;
					}
					if ((m_SensorName.length() != value.m_SensorName.length()) || (m_SensorName.compareTo(value.m_SensorName) != 0))
					{
						return false;
					}
					
					if (!m_SupportedStates.isEqual(value.getSupportedStates()))
					{
						return false;
					}
					if (m_MinimumHorizontalFieldOfViewStartAngle != value.getMinimumHorizontalFieldOfViewStartAngle())
					{
						return false;
					}
					if (m_MaximumHorizontalFieldOfViewStopAngle != value.getMaximumHorizontalFieldOfViewStopAngle())
					{
						return false;
					}
					if (m_MinimumVerticalFieldOfViewStartAngle != value.getMinimumVerticalFieldOfViewStartAngle())
					{
						return false;
					}
					if (m_MaximumVerticalFieldOfViewStopAngle != value.getMaximumVerticalFieldOfViewStopAngle())
					{
						return false;
					}
					if (m_MiniumumUpdateRate != value.getMiniumumUpdateRate())
					{
						return false;
					}
					if (m_MaximumUpdateRate != value.getMaximumUpdateRate())
					{
						return false;
					}
					if (m_MinimumRange != value.getMinimumRange())
					{
						return false;
					}
					if (m_MaximumRange != value.getMaximumRange())
					{
						return false;
					}
					
					if (!m_SupportedCompression.isEqual(value.getSupportedCompression()))
					{
						return false;
					}
					if (m_CoordinateTransformationSupported != value.getCoordinateTransformationSupported())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(RangeSensorCapabilitiesRec value)
				{
					return !this.isEqual(value);
				}
				
				public RangeSensorCapabilitiesRec()
				{
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorName = new String();
					m_SupportedStates = new SupportedStates();
					m_SupportedStates.setParent(this);
					m_MinimumHorizontalFieldOfViewStartAngle = 0;
					m_MaximumHorizontalFieldOfViewStopAngle = 0;
					m_MinimumVerticalFieldOfViewStartAngle = 0;
					m_MaximumVerticalFieldOfViewStopAngle = 0;
					m_MiniumumUpdateRate = 0;
					m_MaximumUpdateRate = 0;
					m_MinimumRange = 0;
					m_MaximumRange = 0;
					m_SupportedCompression = new SupportedCompression();
					m_SupportedCompression.setParent(this);
					m_CoordinateTransformationSupported = 0;
				}
				
				public RangeSensorCapabilitiesRec(RangeSensorCapabilitiesRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_SensorID = 0;
					m_SensorName = new String();
					m_SupportedStates = new SupportedStates();
					m_SupportedStates.setParent(this);
					m_MinimumHorizontalFieldOfViewStartAngle = 0;
					m_MaximumHorizontalFieldOfViewStopAngle = 0;
					m_MinimumVerticalFieldOfViewStartAngle = 0;
					m_MaximumVerticalFieldOfViewStopAngle = 0;
					m_MiniumumUpdateRate = 0;
					m_MaximumUpdateRate = 0;
					m_MinimumRange = 0;
					m_MaximumRange = 0;
					m_SupportedCompression = new SupportedCompression();
					m_SupportedCompression.setParent(this);
					m_CoordinateTransformationSupported = 0;
					
					/// Copy the values
					m_PresenceVector = value.m_PresenceVector;
					m_SensorID = value.m_SensorID;
					m_SensorName = value.m_SensorName;
					m_SupportedStates = value.m_SupportedStates;
					m_MinimumHorizontalFieldOfViewStartAngle = value.m_MinimumHorizontalFieldOfViewStartAngle;
					m_MaximumHorizontalFieldOfViewStopAngle = value.m_MaximumHorizontalFieldOfViewStopAngle;
					m_MinimumVerticalFieldOfViewStartAngle = value.m_MinimumVerticalFieldOfViewStartAngle;
					m_MaximumVerticalFieldOfViewStopAngle = value.m_MaximumVerticalFieldOfViewStopAngle;
					m_MiniumumUpdateRate = value.m_MiniumumUpdateRate;
					m_MaximumUpdateRate = value.m_MaximumUpdateRate;
					m_MinimumRange = value.m_MinimumRange;
					m_MaximumRange = value.m_MaximumRange;
					m_SupportedCompression = value.m_SupportedCompression;
					m_CoordinateTransformationSupported = value.m_CoordinateTransformationSupported;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<RangeSensorCapabilitiesRec> m_RangeSensorCapabilitiesRec;
		
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
				return (long) m_RangeSensorCapabilitiesRec.size();
			}
			
			public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList.RangeSensorCapabilitiesRec getElement(int index)
			{
				return m_RangeSensorCapabilitiesRec.get(index);
			}
			
			public void setElement(int index, RangeSensorCapabilitiesRec value)
			{
				if(m_RangeSensorCapabilitiesRec.size()-1 < index)
				{
					return;
				}
				
				m_RangeSensorCapabilitiesRec.set(index, value);
				m_RangeSensorCapabilitiesRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(RangeSensorCapabilitiesRec value)
			{
				m_RangeSensorCapabilitiesRec.add(value);
				m_RangeSensorCapabilitiesRec.get(m_RangeSensorCapabilitiesRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_RangeSensorCapabilitiesRec.size()-1 < index)
				{
					return 1;
				}
				
				m_RangeSensorCapabilitiesRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_RangeSensorCapabilitiesRec.remove(m_RangeSensorCapabilitiesRec.size()-1);
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
				for (int i = 0; i < m_RangeSensorCapabilitiesRec.size(); i++)
				{
					size += m_RangeSensorCapabilitiesRec.get(i).getSize();
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
				
				int size = (int) m_RangeSensorCapabilitiesRec.size();
				bytes.putShort(pos, (short) size);
				pos += JausUtils.getNumBytes("short");
				for (int i = 0; i < m_RangeSensorCapabilitiesRec.size(); i++)
				{
					m_RangeSensorCapabilitiesRec.get(i).encode(bytes, pos);
					pos += m_RangeSensorCapabilitiesRec.get(i).getSize();
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
				m_RangeSensorCapabilitiesRec = new ArrayList<RangeSensorCapabilitiesRec>();
				for (int i = 0; i <  size; i++)
				{
					RangeSensorCapabilitiesRec item = new RangeSensorCapabilitiesRec();
					item.decode(bytes, pos);
					m_RangeSensorCapabilitiesRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList assign(RangeSensorCapabilitiesList value)
			{
				m_RangeSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_RangeSensorCapabilitiesRec.size(); i++)
				{
					m_RangeSensorCapabilitiesRec.add(value.m_RangeSensorCapabilitiesRec.get(i));
					m_RangeSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(RangeSensorCapabilitiesList value)
			{
				for (int i = 0; i < m_RangeSensorCapabilitiesRec.size(); i++)
				{
					if (!m_RangeSensorCapabilitiesRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(RangeSensorCapabilitiesList value)
			{
				return !this.isEqual(value);
			}
			
			public RangeSensorCapabilitiesList()
			{
				m_parent = null;
				m_RangeSensorCapabilitiesRec = new ArrayList<RangeSensorCapabilitiesRec>();
				for (int i = 0; i < m_RangeSensorCapabilitiesRec.size(); i++)
				{
					m_RangeSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public RangeSensorCapabilitiesList(RangeSensorCapabilitiesList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_RangeSensorCapabilitiesRec = new ArrayList<RangeSensorCapabilitiesRec>();
				for (int i = 0; i < m_RangeSensorCapabilitiesRec.size(); i++)
				{
					m_RangeSensorCapabilitiesRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_RangeSensorCapabilitiesRec.clear();
				
				for (int i = 0; i < value.m_RangeSensorCapabilitiesRec.size(); i++)
				{
					m_RangeSensorCapabilitiesRec.add(value.m_RangeSensorCapabilitiesRec.get(i));
					m_RangeSensorCapabilitiesRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected RangeSensorCapabilitiesList m_RangeSensorCapabilitiesList;
	
		public ReportRangeSensorCapabilities.Body.RangeSensorCapabilitiesList getRangeSensorCapabilitiesList()
		{
			return m_RangeSensorCapabilitiesList;
		}
		
		public void setRangeSensorCapabilitiesList(RangeSensorCapabilitiesList value)
		{
			m_RangeSensorCapabilitiesList = value;
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
			
			size += m_RangeSensorCapabilitiesList.getSize();
			
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
			
			m_RangeSensorCapabilitiesList.encode(bytes, pos);
			pos += m_RangeSensorCapabilitiesList.getSize();
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
			
			m_RangeSensorCapabilitiesList.decode(bytes, pos);
			pos += m_RangeSensorCapabilitiesList.getSize();
		}
		
		public ReportRangeSensorCapabilities.Body assign(Body value)
		{
			m_RangeSensorCapabilitiesList = value.m_RangeSensorCapabilitiesList;
			m_RangeSensorCapabilitiesList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_RangeSensorCapabilitiesList.isEqual(value.m_RangeSensorCapabilitiesList))
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
			m_RangeSensorCapabilitiesList = new RangeSensorCapabilitiesList();
			m_RangeSensorCapabilitiesList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_RangeSensorCapabilitiesList = new RangeSensorCapabilitiesList();
			m_RangeSensorCapabilitiesList.setParent(this);
			
			/// Copy the values
			m_RangeSensorCapabilitiesList = value.m_RangeSensorCapabilitiesList;
			m_RangeSensorCapabilitiesList.setParent(this);
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
	public ReportRangeSensorCapabilities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportRangeSensorCapabilities.Body getBody()
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
	
	public ReportRangeSensorCapabilities setAs(ReportRangeSensorCapabilities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportRangeSensorCapabilities value)
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
	
	public boolean notEquals(ReportRangeSensorCapabilities value)
	{
		return !isEqual(value);
	}
	
	public ReportRangeSensorCapabilities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportRangeSensorCapabilities(ReportRangeSensorCapabilities value)
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

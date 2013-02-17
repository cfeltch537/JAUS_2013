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

public class ReportAccelerationState extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4417;
	
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
			
			public ReportAccelerationState.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4417;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4417;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportAccelerationState.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportAccelerationState.AppHeader assign(AppHeader value)
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
		public static class  ReportAccelerationStateRec
		{
			public static class  TimeStamp
			{
			
				protected ReportAccelerationStateRec m_parent;
				protected long m_SubFields;
			
				public void setParent(ReportAccelerationStateRec parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setPresenceVector(2);
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
				
				public ReportAccelerationState.Body.ReportAccelerationStateRec.TimeStamp assign(TimeStamp value)
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
		
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected long m_Acceleration_X;
			protected long m_Acceleration_Y;
			protected long m_Acceleration_Z;
			protected long m_Acceleration_RMS;
			protected long m_RollAcceleration;
			protected long m_PitchAcceleration;
			protected long m_YawAcceleration;
			protected int m_RotationalAcceleration_RMS;
			protected TimeStamp m_TimeStamp;
		
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
			
			public double getAcceleration_X()
			{
				double value;
				
				double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
				double bias = -1310.68;
				
				value = m_Acceleration_X * scaleFactor + bias;
				
				return value;
			}
			
			public void setAcceleration_X(double value)
			{
				if ((value >= -1310.68) && (value <= 1310.68))
				{
					double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
					double bias = -1310.68;
					
					m_Acceleration_X= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getAcceleration_Y()
			{
				double value;
				
				double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
				double bias = -1310.68;
				
				value = m_Acceleration_Y * scaleFactor + bias;
				
				return value;
			}
			
			public void setAcceleration_Y(double value)
			{
				if ((value >= -1310.68) && (value <= 1310.68))
				{
					double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
					double bias = -1310.68;
					
					m_Acceleration_Y= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getAcceleration_Z()
			{
				double value;
				
				double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
				double bias = -1310.68;
				
				value = m_Acceleration_Z * scaleFactor + bias;
				
				return value;
			}
			
			public void setAcceleration_Z(double value)
			{
				if ((value >= -1310.68) && (value <= 1310.68))
				{
					double scaleFactor = ( 1310.68 - -1310.68 ) / 4.294967295E9;
					double bias = -1310.68;
					
					m_Acceleration_Z= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAcceleration_RMSValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getAcceleration_RMS()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Acceleration_RMS * scaleFactor + bias;
				
				return value;
			}
			
			public void setAcceleration_RMS(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Acceleration_RMS= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getRollAcceleration()
			{
				double value;
				
				double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
				double bias = -13106.8;
				
				value = m_RollAcceleration * scaleFactor + bias;
				
				return value;
			}
			
			public void setRollAcceleration(double value)
			{
				if ((value >= -13106.8) && (value <= 13106.8))
				{
					double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
					double bias = -13106.8;
					
					m_RollAcceleration= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getPitchAcceleration()
			{
				double value;
				
				double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
				double bias = -13106.8;
				
				value = m_PitchAcceleration * scaleFactor + bias;
				
				return value;
			}
			
			public void setPitchAcceleration(double value)
			{
				if ((value >= -13106.8) && (value <= 13106.8))
				{
					double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
					double bias = -13106.8;
					
					m_PitchAcceleration= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getYawAcceleration()
			{
				double value;
				
				double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
				double bias = -13106.8;
				
				value = m_YawAcceleration * scaleFactor + bias;
				
				return value;
			}
			
			public void setYawAcceleration(double value)
			{
				if ((value >= -13106.8) && (value <= 13106.8))
				{
					double scaleFactor = ( 13106.8 - -13106.8 ) / 4.294967295E9;
					double bias = -13106.8;
					
					m_YawAcceleration= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isRotationalAcceleration_RMSValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getRotationalAcceleration_RMS()
			{
				double value;
				
				double scaleFactor = ( 3.14159265358979323846 - 0 ) / 65535.0;
				double bias = 0;
				
				value = m_RotationalAcceleration_RMS * scaleFactor + bias;
				
				return value;
			}
			
			public void setRotationalAcceleration_RMS(double value)
			{
				if ((value >= 0) && (value <= 3.14159265358979323846))
				{
					double scaleFactor = ( 3.14159265358979323846 - 0 ) / 65535.0;
					double bias = 0;
					
					m_RotationalAcceleration_RMS= (int)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isTimeStampValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public ReportAccelerationState.Body.ReportAccelerationStateRec.TimeStamp getTimeStamp()
			{
				return m_TimeStamp;
			}
			
			public void setTimeStamp(TimeStamp value)
			{
				m_TimeStamp = value;
				setPresenceVector(2);
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
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("int");
				}
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					size += m_TimeStamp.getSize();
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
				bytes.putInt(pos, (int) m_Acceleration_X);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Acceleration_Y);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Acceleration_Z);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_Acceleration_RMS);
					pos += JausUtils.getNumBytes("int");
				}
				bytes.putInt(pos, (int) m_RollAcceleration);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_PitchAcceleration);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_YawAcceleration);
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					bytes.putShort(pos, (short) m_RotationalAcceleration_RMS);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					m_TimeStamp.encode(bytes, pos);
					pos += m_TimeStamp.getSize();
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
				m_Acceleration_X = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Acceleration_Y = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Acceleration_Z = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(0))
				{
					m_Acceleration_RMS = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				m_RollAcceleration = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_PitchAcceleration = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_YawAcceleration = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				if (checkPresenceVector(1))
				{
					m_RotationalAcceleration_RMS = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					m_TimeStamp.decode(bytes, pos);
					pos += m_TimeStamp.getSize();
				}
			}
			
			public ReportAccelerationState.Body.ReportAccelerationStateRec assign(ReportAccelerationStateRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_Acceleration_X = value.m_Acceleration_X;
				m_Acceleration_Y = value.m_Acceleration_Y;
				m_Acceleration_Z = value.m_Acceleration_Z;
				m_Acceleration_RMS = value.m_Acceleration_RMS;
				m_RollAcceleration = value.m_RollAcceleration;
				m_PitchAcceleration = value.m_PitchAcceleration;
				m_YawAcceleration = value.m_YawAcceleration;
				m_RotationalAcceleration_RMS = value.m_RotationalAcceleration_RMS;
				m_TimeStamp = value.m_TimeStamp;
				
				return this;
			}
			
			public boolean isEqual(ReportAccelerationStateRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_Acceleration_X != value.getAcceleration_X())
				{
					return false;
				}
				if (m_Acceleration_Y != value.getAcceleration_Y())
				{
					return false;
				}
				if (m_Acceleration_Z != value.getAcceleration_Z())
				{
					return false;
				}
				if (m_Acceleration_RMS != value.getAcceleration_RMS())
				{
					return false;
				}
				if (m_RollAcceleration != value.getRollAcceleration())
				{
					return false;
				}
				if (m_PitchAcceleration != value.getPitchAcceleration())
				{
					return false;
				}
				if (m_YawAcceleration != value.getYawAcceleration())
				{
					return false;
				}
				if (m_RotationalAcceleration_RMS != value.getRotationalAcceleration_RMS())
				{
					return false;
				}
				
				if (!m_TimeStamp.isEqual(value.getTimeStamp()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ReportAccelerationStateRec value)
			{
				return !this.isEqual(value);
			}
			
			public ReportAccelerationStateRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Acceleration_X = 0;
				m_Acceleration_Y = 0;
				m_Acceleration_Z = 0;
				m_Acceleration_RMS = 0;
				m_RollAcceleration = 0;
				m_PitchAcceleration = 0;
				m_YawAcceleration = 0;
				m_RotationalAcceleration_RMS = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
			}
			
			public ReportAccelerationStateRec(ReportAccelerationStateRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Acceleration_X = 0;
				m_Acceleration_Y = 0;
				m_Acceleration_Z = 0;
				m_Acceleration_RMS = 0;
				m_RollAcceleration = 0;
				m_PitchAcceleration = 0;
				m_YawAcceleration = 0;
				m_RotationalAcceleration_RMS = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_Acceleration_X = value.m_Acceleration_X;
				m_Acceleration_Y = value.m_Acceleration_Y;
				m_Acceleration_Z = value.m_Acceleration_Z;
				m_Acceleration_RMS = value.m_Acceleration_RMS;
				m_RollAcceleration = value.m_RollAcceleration;
				m_PitchAcceleration = value.m_PitchAcceleration;
				m_YawAcceleration = value.m_YawAcceleration;
				m_RotationalAcceleration_RMS = value.m_RotationalAcceleration_RMS;
				m_TimeStamp = value.m_TimeStamp;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ReportAccelerationStateRec m_ReportAccelerationStateRec;
	
		public ReportAccelerationState.Body.ReportAccelerationStateRec getReportAccelerationStateRec()
		{
			return m_ReportAccelerationStateRec;
		}
		
		public void setReportAccelerationStateRec(ReportAccelerationStateRec value)
		{
			m_ReportAccelerationStateRec = value;
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
			
			size += m_ReportAccelerationStateRec.getSize();
			
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
			
			m_ReportAccelerationStateRec.encode(bytes, pos);
			pos += m_ReportAccelerationStateRec.getSize();
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
			
			m_ReportAccelerationStateRec.decode(bytes, pos);
			pos += m_ReportAccelerationStateRec.getSize();
		}
		
		public ReportAccelerationState.Body assign(Body value)
		{
			m_ReportAccelerationStateRec = value.m_ReportAccelerationStateRec;
			m_ReportAccelerationStateRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ReportAccelerationStateRec.isEqual(value.getReportAccelerationStateRec()))
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
			m_ReportAccelerationStateRec = new ReportAccelerationStateRec();
			m_ReportAccelerationStateRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ReportAccelerationStateRec = new ReportAccelerationStateRec();
			m_ReportAccelerationStateRec.setParent(this);
			
			/// Copy the values
			m_ReportAccelerationStateRec = value.m_ReportAccelerationStateRec;
			m_ReportAccelerationStateRec.setParent(this);
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
	public ReportAccelerationState.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportAccelerationState.Body getBody()
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
	
	public ReportAccelerationState setAs(ReportAccelerationState value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportAccelerationState value)
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
	
	public boolean notEquals(ReportAccelerationState value)
	{
		return !isEqual(value);
	}
	
	public ReportAccelerationState()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportAccelerationState(ReportAccelerationState value)
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

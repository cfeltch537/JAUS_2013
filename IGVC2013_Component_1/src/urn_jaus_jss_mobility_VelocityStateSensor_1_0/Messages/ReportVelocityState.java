package src.urn_jaus_jss_mobility_VelocityStateSensor_1_0.Messages;

import framework.messages.Message;
import framework.JausUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportVelocityState extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4404;
	
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
			
			public ReportVelocityState.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4404;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4404;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportVelocityState.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportVelocityState.AppHeader assign(AppHeader value)
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
		public static class  ReportVelocityStateRec
		{
			public static class  TimeStamp
			{
			
				protected ReportVelocityStateRec m_parent;
				protected long m_SubFields;
			
				public void setParent(ReportVelocityStateRec parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setPresenceVector(8);
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
				
				public ReportVelocityState.Body.ReportVelocityStateRec.TimeStamp assign(TimeStamp value)
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
			protected int m_PresenceVectorTemp;
			protected long m_Velocity_X;
			protected long m_Velocity_Y;
			protected long m_Velocity_Z;
			protected long m_Velocity_RMS;
			protected int m_RollRate;
			protected int m_PitchRate;
			protected int m_YawRate;
			protected int m_Rate_RMS;
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
			
			public boolean isVelocity_XValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getVelocity_X()
			{
				double value;
				
				double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
				double bias = -327.68;
				
				value = m_Velocity_X * scaleFactor + bias;
				
				return value;
			}
			
			public void setVelocity_X(double value)
			{
				if ((value >= -327.68) && (value <= 327.67))
				{
					double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
					double bias = -327.68;
					
					m_Velocity_X= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isVelocity_YValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getVelocity_Y()
			{
				double value;
				
				double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
				double bias = -327.68;
				
				value = m_Velocity_Y * scaleFactor + bias;
				
				return value;
			}
			
			public void setVelocity_Y(double value)
			{
				if ((value >= -327.68) && (value <= 327.67))
				{
					double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
					double bias = -327.68;
					
					m_Velocity_Y= (long)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isVelocity_ZValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public double getVelocity_Z()
			{
				double value;
				
				double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
				double bias = -327.68;
				
				value = m_Velocity_Z * scaleFactor + bias;
				
				return value;
			}
			
			public void setVelocity_Z(double value)
			{
				if ((value >= -327.68) && (value <= 327.67))
				{
					double scaleFactor = ( 327.67 - -327.68 ) / 4.294967295E9;
					double bias = -327.68;
					
					m_Velocity_Z= (long)((value - bias) / scaleFactor);
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isVelocity_RMSValid()
			{
				if (checkPresenceVector(3))
				{
					return true;
				}
				return false;
			}
			
			public double getVelocity_RMS()
			{
				double value;
				
				double scaleFactor = ( 100 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Velocity_RMS * scaleFactor + bias;
				
				return value;
			}
			
			public void setVelocity_RMS(double value)
			{
				if ((value >= 0) && (value <= 100))
				{
					double scaleFactor = ( 100 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Velocity_RMS= (long)((value - bias) / scaleFactor);
					setPresenceVector(3);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isRollRateValid()
			{
				if (checkPresenceVector(4))
				{
					return true;
				}
				return false;
			}
			
			public double getRollRate()
			{
				double value;
				
				double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
				double bias = -32.768;
				
				value = m_RollRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setRollRate(double value)
			{
				if ((value >= -32.768) && (value <= 32.767))
				{
					double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
					double bias = -32.768;
					
					m_RollRate= (int)((value - bias) / scaleFactor);
					setPresenceVector(4);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPitchRateValid()
			{
				if (checkPresenceVector(5))
				{
					return true;
				}
				return false;
			}
			
			public double getPitchRate()
			{
				double value;
				
				double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
				double bias = -32.768;
				
				value = m_PitchRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setPitchRate(double value)
			{
				if ((value >= -32.768) && (value <= 32.767))
				{
					double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
					double bias = -32.768;
					
					m_PitchRate= (int)((value - bias) / scaleFactor);
					setPresenceVector(5);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isYawRateValid()
			{
				if (checkPresenceVector(6))
				{
					return true;
				}
				return false;
			}
			
			public double getYawRate()
			{
				double value;
				
				double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
				double bias = -32.768;
				
				value = m_YawRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setYawRate(double value)
			{
				if ((value >= -32.768) && (value <= 32.767))
				{
					double scaleFactor = ( 32.767 - -32.768 ) / 65535.0;
					double bias = -32.768;
					
					m_YawRate= (int)((value - bias) / scaleFactor);
					setPresenceVector(6);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isRate_RMSValid()
			{
				if (checkPresenceVector(7))
				{
					return true;
				}
				return false;
			}
			
			public double getRate_RMS()
			{
				double value;
				
				double scaleFactor = ( 3.14159265358979323846 - 0 ) / 65535.0;
				double bias = 0;
				
				value = m_Rate_RMS * scaleFactor + bias;
				
				return value;
			}
			
			public void setRate_RMS(double value)
			{
				if ((value >= 0) && (value <= 3.14159265358979323846))
				{
					double scaleFactor = ( 3.14159265358979323846 - 0 ) / 65535.0;
					double bias = 0;
					
					m_Rate_RMS= (int)((value - bias) / scaleFactor);
					setPresenceVector(7);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isTimeStampValid()
			{
				if (checkPresenceVector(8))
				{
					return true;
				}
				return false;
			}
			
			public ReportVelocityState.Body.ReportVelocityStateRec.TimeStamp getTimeStamp()
			{
				return m_TimeStamp;
			}
			
			public void setTimeStamp(TimeStamp value)
			{
				m_TimeStamp = value;
				setPresenceVector(8);
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
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("int");
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
					size += JausUtils.getNumBytes("short");
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
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(8))
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
					int m_PresenceVectorTemp = (int) JausUtils.getPVInt(m_PresenceVector);
				bytes.putShort(pos, (short) m_PresenceVectorTemp);
				pos += JausUtils.getNumBytes("short");
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_Velocity_X);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					bytes.putInt(pos, (int) m_Velocity_Y);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					bytes.putInt(pos, (int) m_Velocity_Z);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					bytes.putInt(pos, (int) m_Velocity_RMS);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					bytes.putShort(pos, (short) m_RollRate);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(5))
				{
					bytes.putShort(pos, (short) m_PitchRate);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(6))
				{
					bytes.putShort(pos, (short) m_YawRate);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(7))
				{
					bytes.putShort(pos, (short) m_Rate_RMS);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(8))
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
					int m_PresenceVectorTemp = 0;
				m_PresenceVectorTemp = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				m_PresenceVector = JausUtils.setPV(m_PresenceVectorTemp);
				}
				catch(Exception e)
				{
					logger.log(Level.SEVERE, null, e);
				}
				if (checkPresenceVector(0))
				{
					m_Velocity_X = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					m_Velocity_Y = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					m_Velocity_Z = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					m_Velocity_RMS = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					m_RollRate = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(5))
				{
					m_PitchRate = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(6))
				{
					m_YawRate = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(7))
				{
					m_Rate_RMS = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(8))
				{
					m_TimeStamp.decode(bytes, pos);
					pos += m_TimeStamp.getSize();
				}
			}
			
			public ReportVelocityState.Body.ReportVelocityStateRec assign(ReportVelocityStateRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_Velocity_X = value.m_Velocity_X;
				m_Velocity_Y = value.m_Velocity_Y;
				m_Velocity_Z = value.m_Velocity_Z;
				m_Velocity_RMS = value.m_Velocity_RMS;
				m_RollRate = value.m_RollRate;
				m_PitchRate = value.m_PitchRate;
				m_YawRate = value.m_YawRate;
				m_Rate_RMS = value.m_Rate_RMS;
				m_TimeStamp = value.m_TimeStamp;
				
				return this;
			}
			
			public boolean isEqual(ReportVelocityStateRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_Velocity_X != value.getVelocity_X())
				{
					return false;
				}
				if (m_Velocity_Y != value.getVelocity_Y())
				{
					return false;
				}
				if (m_Velocity_Z != value.getVelocity_Z())
				{
					return false;
				}
				if (m_Velocity_RMS != value.getVelocity_RMS())
				{
					return false;
				}
				if (m_RollRate != value.getRollRate())
				{
					return false;
				}
				if (m_PitchRate != value.getPitchRate())
				{
					return false;
				}
				if (m_YawRate != value.getYawRate())
				{
					return false;
				}
				if (m_Rate_RMS != value.getRate_RMS())
				{
					return false;
				}
				
				if (!m_TimeStamp.isEqual(value.getTimeStamp()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ReportVelocityStateRec value)
			{
				return !this.isEqual(value);
			}
			
			public ReportVelocityStateRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Velocity_X = 0;
				m_Velocity_Y = 0;
				m_Velocity_Z = 0;
				m_Velocity_RMS = 0;
				m_RollRate = 0;
				m_PitchRate = 0;
				m_YawRate = 0;
				m_Rate_RMS = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
			}
			
			public ReportVelocityStateRec(ReportVelocityStateRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Velocity_X = 0;
				m_Velocity_Y = 0;
				m_Velocity_Z = 0;
				m_Velocity_RMS = 0;
				m_RollRate = 0;
				m_PitchRate = 0;
				m_YawRate = 0;
				m_Rate_RMS = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_Velocity_X = value.m_Velocity_X;
				m_Velocity_Y = value.m_Velocity_Y;
				m_Velocity_Z = value.m_Velocity_Z;
				m_Velocity_RMS = value.m_Velocity_RMS;
				m_RollRate = value.m_RollRate;
				m_PitchRate = value.m_PitchRate;
				m_YawRate = value.m_YawRate;
				m_Rate_RMS = value.m_Rate_RMS;
				m_TimeStamp = value.m_TimeStamp;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ReportVelocityStateRec m_ReportVelocityStateRec;
	
		public ReportVelocityState.Body.ReportVelocityStateRec getReportVelocityStateRec()
		{
			return m_ReportVelocityStateRec;
		}
		
		public void setReportVelocityStateRec(ReportVelocityStateRec value)
		{
			m_ReportVelocityStateRec = value;
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
			
			size += m_ReportVelocityStateRec.getSize();
			
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
			
			m_ReportVelocityStateRec.encode(bytes, pos);
			pos += m_ReportVelocityStateRec.getSize();
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
			
			m_ReportVelocityStateRec.decode(bytes, pos);
			pos += m_ReportVelocityStateRec.getSize();
		}
		
		public ReportVelocityState.Body assign(Body value)
		{
			m_ReportVelocityStateRec = value.m_ReportVelocityStateRec;
			m_ReportVelocityStateRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ReportVelocityStateRec.isEqual(value.getReportVelocityStateRec()))
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
			m_ReportVelocityStateRec = new ReportVelocityStateRec();
			m_ReportVelocityStateRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ReportVelocityStateRec = new ReportVelocityStateRec();
			m_ReportVelocityStateRec.setParent(this);
			
			/// Copy the values
			m_ReportVelocityStateRec = value.m_ReportVelocityStateRec;
			m_ReportVelocityStateRec.setParent(this);
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
	public ReportVelocityState.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportVelocityState.Body getBody()
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
	
	public ReportVelocityState setAs(ReportVelocityState value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportVelocityState value)
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
	
	public boolean notEquals(ReportVelocityState value)
	{
		return !isEqual(value);
	}
	
	public ReportVelocityState()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportVelocityState(ReportVelocityState value)
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

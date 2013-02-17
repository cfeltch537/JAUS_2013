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

public class ReportTime extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4011;
	
	public static class  MsgHeader
	{
		public static class  HeaderRec
		{
		
			protected MsgHeader m_parent;
			protected int m_MessageID;
		
			public void setParent(MsgHeader parent)
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
			
			public ReportTime.MsgHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4011;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4011;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportTime.MsgHeader.HeaderRec getHeaderRec()
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
		
		public ReportTime.MsgHeader assign(MsgHeader value)
		{
			m_HeaderRec = value.m_HeaderRec;
			m_HeaderRec.setParent(this);
			
			return this;
		}
		
		public boolean isEqual(MsgHeader value)
		{
			if (!m_HeaderRec.isEqual(value.getHeaderRec()))
			{
				return false;
			}
			return true;
		}
		
		public boolean notEquals(MsgHeader value)
		{
			return !this.isEqual(value);
		}
		
		public MsgHeader()
		{
			m_HeaderRec = new HeaderRec();
			m_HeaderRec.setParent(this);
		}
		
		public MsgHeader(MsgHeader value)
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
		public static class  TimeRec
		{
			public static class  TimeStamp
			{
			
				protected TimeRec m_parent;
				protected long m_SubFields;
			
				public void setParent(TimeRec parent)
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
				
				public ReportTime.Body.TimeRec.TimeStamp assign(TimeStamp value)
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
			public static class  DateStamp
			{
			
				protected TimeRec m_parent;
				protected int m_SubFields;
			
				public void setParent(TimeRec parent)
				{
					m_parent = parent;
				}
				
				public void setParentPresenceVector()
				{
					if(m_parent != null )
					{
						m_parent.setPresenceVector(1);
						m_parent.setParentPresenceVector();
					}
				}
				
				public int getDay()
				{
					BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
					BitSet subFieldBitSet = new BitSet(5);
					int i = 0;
					
					for (int index = 0; index <= 4; index++)
					{
					    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
					}
					
					return (int)JausUtils.getPVLong(subFieldBitSet);
				}
				
				public int setDay(int value)
				{
					if (((value >= 1) && (value <= 31)))
					{
						BitSet bfbs = JausUtils.setPV(m_SubFields);
						BitSet sfbs = new BitSet(5);
						sfbs = JausUtils.setPV(value);
						int i = 0;
						
						for (int index = 0; index <= 4; index++)
						{
							bfbs.set(index, sfbs.get(i++));
						}
						
						m_SubFields = (int) JausUtils.getPVLong(bfbs);
						setParentPresenceVector();
						return 0;
					}
					return 1;
				}
				
				public int getMonth()
				{
					BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
					BitSet subFieldBitSet = new BitSet(4);
					int i = 0;
					
					for (int index = 5; index <= 8; index++)
					{
					    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
					}
					
					return (int)JausUtils.getPVLong(subFieldBitSet);
				}
				
				public int setMonth(int value)
				{
					if (((value >= 1) && (value <= 12)))
					{
						BitSet bfbs = JausUtils.setPV(m_SubFields);
						BitSet sfbs = new BitSet(4);
						sfbs = JausUtils.setPV(value);
						int i = 0;
						
						for (int index = 5; index <= 8; index++)
						{
							bfbs.set(index, sfbs.get(i++));
						}
						
						m_SubFields = (int) JausUtils.getPVLong(bfbs);
						setParentPresenceVector();
						return 0;
					}
					return 1;
				}
				
				public int getYear()
				{
					BitSet bitFieldBitSet = JausUtils.setPV(m_SubFields);
					BitSet subFieldBitSet = new BitSet(7);
					int i = 0;
					
					for (int index = 9; index <= 15; index++)
					{
					    subFieldBitSet.set(i++, bitFieldBitSet.get(index));
					}
					
					return (int)JausUtils.getPVLong(subFieldBitSet);
				}
				
				public int setYear(int value)
				{
					if (((value >= 0) && (value <= 127)))
					{
						BitSet bfbs = JausUtils.setPV(m_SubFields);
						BitSet sfbs = new BitSet(7);
						sfbs = JausUtils.setPV(value);
						int i = 0;
						
						for (int index = 9; index <= 15; index++)
						{
							bfbs.set(index, sfbs.get(i++));
						}
						
						m_SubFields = (int) JausUtils.getPVLong(bfbs);
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
					
					
					bytes.putShort(pos, (short) m_SubFields);
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
					
					m_SubFields = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				
				public ReportTime.Body.TimeRec.DateStamp assign(DateStamp value)
				{
					this.m_SubFields = value.m_SubFields;
					
					return this;
				}
				
				public boolean isEqual(DateStamp value)
				{
					return this.m_SubFields == value.getYear();
				}
				
				public boolean notEquals(DateStamp value)
				{
					return !this.isEqual(value);
				}
				
				public DateStamp()
				{
					m_parent = null;
					m_SubFields = 0;
				}
				
				public DateStamp(DateStamp value)
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
			protected TimeStamp m_TimeStamp;
			protected DateStamp m_DateStamp;
		
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
			
			public boolean isTimeStampValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public ReportTime.Body.TimeRec.TimeStamp getTimeStamp()
			{
				return m_TimeStamp;
			}
			
			public void setTimeStamp(TimeStamp value)
			{
				m_TimeStamp = value;
				setPresenceVector(0);
				setParentPresenceVector();
			}
			
			public boolean isDateStampValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public ReportTime.Body.TimeRec.DateStamp getDateStamp()
			{
				return m_DateStamp;
			}
			
			public void setDateStamp(DateStamp value)
			{
				m_DateStamp = value;
				setPresenceVector(1);
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
				if (checkPresenceVector(0))
				{
					size += m_TimeStamp.getSize();
				}
				if (checkPresenceVector(1))
				{
					size += m_DateStamp.getSize();
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
					m_TimeStamp.encode(bytes, pos);
					pos += m_TimeStamp.getSize();
				}
				if (checkPresenceVector(1))
				{
					m_DateStamp.encode(bytes, pos);
					pos += m_DateStamp.getSize();
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
					m_TimeStamp.decode(bytes, pos);
					pos += m_TimeStamp.getSize();
				}
				if (checkPresenceVector(1))
				{
					m_DateStamp.decode(bytes, pos);
					pos += m_DateStamp.getSize();
				}
			}
			
			public ReportTime.Body.TimeRec assign(TimeRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_TimeStamp = value.m_TimeStamp;
				m_DateStamp = value.m_DateStamp;
				
				return this;
			}
			
			public boolean isEqual(TimeRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				
				if (!m_TimeStamp.isEqual(value.getTimeStamp()))
				{
					return false;
				}
				
				if (!m_DateStamp.isEqual(value.getDateStamp()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(TimeRec value)
			{
				return !this.isEqual(value);
			}
			
			public TimeRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
				m_DateStamp = new DateStamp();
				m_DateStamp.setParent(this);
			}
			
			public TimeRec(TimeRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_TimeStamp = new TimeStamp();
				m_TimeStamp.setParent(this);
				m_DateStamp = new DateStamp();
				m_DateStamp.setParent(this);
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_TimeStamp = value.m_TimeStamp;
				m_DateStamp = value.m_DateStamp;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected TimeRec m_TimeRec;
	
		public ReportTime.Body.TimeRec getTimeRec()
		{
			return m_TimeRec;
		}
		
		public void setTimeRec(TimeRec value)
		{
			m_TimeRec = value;
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
			
			size += m_TimeRec.getSize();
			
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
			
			m_TimeRec.encode(bytes, pos);
			pos += m_TimeRec.getSize();
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
			
			m_TimeRec.decode(bytes, pos);
			pos += m_TimeRec.getSize();
		}
		
		public ReportTime.Body assign(Body value)
		{
			m_TimeRec = value.m_TimeRec;
			m_TimeRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_TimeRec.isEqual(value.getTimeRec()))
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
			m_TimeRec = new TimeRec();
			m_TimeRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_TimeRec = new TimeRec();
			m_TimeRec.setParent(this);
			
			/// Copy the values
			m_TimeRec = value.m_TimeRec;
			m_TimeRec.setParent(this);
			/// This code is currently not supported
		}
		
		public void finalize()
		{
		}
		
	}
	protected MsgHeader m_MsgHeader;
	protected Body m_Body;
	public long getID()
	{
	return ID;
 }
	public ReportTime.MsgHeader getMsgHeader()
	{
		return m_MsgHeader;
	}
	
	public void setMsgHeader(MsgHeader value)
	{
		m_MsgHeader = value;
	}
	
	public ReportTime.Body getBody()
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
		
		size += m_MsgHeader.getSize();
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
		
		m_MsgHeader.encode(bytes, pos);
		pos += m_MsgHeader.getSize();
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
		
		m_MsgHeader.decode(bytes, pos);
		pos += m_MsgHeader.getSize();
		m_Body.decode(bytes, pos);
		pos += m_Body.getSize();
	}
	
	public ReportTime setAs(ReportTime value)
	{
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportTime value)
	{
		if (!m_MsgHeader.isEqual(value.getMsgHeader()))
		{
			return false;
		}
		if (!m_Body.isEqual(value.getBody()))
		{
			return false;
		}
		
		return true;
	}
	
	public boolean notEquals(ReportTime value)
	{
		return !isEqual(value);
	}
	
	public ReportTime()
	{
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportTime(ReportTime value)
	{
		/// Initiliaze the protected variables
		m_MsgHeader = new MsgHeader();
		m_Body = new Body();
		m_IsCommand = false;
		
		/// Copy the values
		m_MsgHeader = value.m_MsgHeader;
		m_Body = value.m_Body;
	}
	
}

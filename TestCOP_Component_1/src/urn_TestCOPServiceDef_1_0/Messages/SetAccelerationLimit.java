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

public class SetAccelerationLimit extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0416;
	
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
			
			public SetAccelerationLimit.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0416;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0416;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetAccelerationLimit.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetAccelerationLimit.AppHeader assign(AppHeader value)
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
		public static class  AccelerationLimitRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected short m_CommandType;
			protected long m_Acceleration_X;
			protected long m_Acceleration_Y;
			protected long m_Acceleration_Z;
			protected long m_RollAcceleration;
			protected long m_PitchAcceleration;
			protected long m_YawAcceleration;
		
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
			
			public short getCommandType()
			{
				return m_CommandType;
			}
			
			public void setCommandType(short value)
			{
				if ((value == 1) || (value == 2))
				{
					m_CommandType = value;
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAcceleration_XValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
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
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAcceleration_YValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
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
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAcceleration_ZValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
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
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isRollAccelerationValid()
			{
				if (checkPresenceVector(3))
				{
					return true;
				}
				return false;
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
					setPresenceVector(3);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPitchAccelerationValid()
			{
				if (checkPresenceVector(4))
				{
					return true;
				}
				return false;
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
					setPresenceVector(4);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isYawAccelerationValid()
			{
				if (checkPresenceVector(5))
				{
					return true;
				}
				return false;
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
					setPresenceVector(5);
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
				size += JausUtils.getNumBytes("byte");
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
					size += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(5))
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
				bytes.put(pos, (byte) m_CommandType);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_Acceleration_X);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					bytes.putInt(pos, (int) m_Acceleration_Y);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					bytes.putInt(pos, (int) m_Acceleration_Z);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					bytes.putInt(pos, (int) m_RollAcceleration);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					bytes.putInt(pos, (int) m_PitchAcceleration);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(5))
				{
					bytes.putInt(pos, (int) m_YawAcceleration);
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
				m_CommandType = (short) (bytes.get(pos) & 0xff);
				pos += JausUtils.getNumBytes("byte");
				if (checkPresenceVector(0))
				{
					m_Acceleration_X = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					m_Acceleration_Y = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					m_Acceleration_Z = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					m_RollAcceleration = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					m_PitchAcceleration = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(5))
				{
					m_YawAcceleration = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
			}
			
			public SetAccelerationLimit.Body.AccelerationLimitRec assign(AccelerationLimitRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_CommandType = value.m_CommandType;
				m_Acceleration_X = value.m_Acceleration_X;
				m_Acceleration_Y = value.m_Acceleration_Y;
				m_Acceleration_Z = value.m_Acceleration_Z;
				m_RollAcceleration = value.m_RollAcceleration;
				m_PitchAcceleration = value.m_PitchAcceleration;
				m_YawAcceleration = value.m_YawAcceleration;
				
				return this;
			}
			
			public boolean isEqual(AccelerationLimitRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_CommandType != value.getCommandType())
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
				
				return true;
			}
			
			public boolean notEquals(AccelerationLimitRec value)
			{
				return !this.isEqual(value);
			}
			
			public AccelerationLimitRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_CommandType = 0;
				m_Acceleration_X = 0;
				m_Acceleration_Y = 0;
				m_Acceleration_Z = 0;
				m_RollAcceleration = 0;
				m_PitchAcceleration = 0;
				m_YawAcceleration = 0;
			}
			
			public AccelerationLimitRec(AccelerationLimitRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_CommandType = 0;
				m_Acceleration_X = 0;
				m_Acceleration_Y = 0;
				m_Acceleration_Z = 0;
				m_RollAcceleration = 0;
				m_PitchAcceleration = 0;
				m_YawAcceleration = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_CommandType = value.m_CommandType;
				m_Acceleration_X = value.m_Acceleration_X;
				m_Acceleration_Y = value.m_Acceleration_Y;
				m_Acceleration_Z = value.m_Acceleration_Z;
				m_RollAcceleration = value.m_RollAcceleration;
				m_PitchAcceleration = value.m_PitchAcceleration;
				m_YawAcceleration = value.m_YawAcceleration;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected AccelerationLimitRec m_AccelerationLimitRec;
	
		public SetAccelerationLimit.Body.AccelerationLimitRec getAccelerationLimitRec()
		{
			return m_AccelerationLimitRec;
		}
		
		public void setAccelerationLimitRec(AccelerationLimitRec value)
		{
			m_AccelerationLimitRec = value;
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
			
			size += m_AccelerationLimitRec.getSize();
			
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
			
			m_AccelerationLimitRec.encode(bytes, pos);
			pos += m_AccelerationLimitRec.getSize();
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
			
			m_AccelerationLimitRec.decode(bytes, pos);
			pos += m_AccelerationLimitRec.getSize();
		}
		
		public SetAccelerationLimit.Body assign(Body value)
		{
			m_AccelerationLimitRec = value.m_AccelerationLimitRec;
			m_AccelerationLimitRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_AccelerationLimitRec.isEqual(value.getAccelerationLimitRec()))
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
			m_AccelerationLimitRec = new AccelerationLimitRec();
			m_AccelerationLimitRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_AccelerationLimitRec = new AccelerationLimitRec();
			m_AccelerationLimitRec.setParent(this);
			
			/// Copy the values
			m_AccelerationLimitRec = value.m_AccelerationLimitRec;
			m_AccelerationLimitRec.setParent(this);
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
	public SetAccelerationLimit.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetAccelerationLimit.Body getBody()
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
	
	public SetAccelerationLimit setAs(SetAccelerationLimit value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetAccelerationLimit value)
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
	
	public boolean notEquals(SetAccelerationLimit value)
	{
		return !isEqual(value);
	}
	
	public SetAccelerationLimit()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetAccelerationLimit(SetAccelerationLimit value)
	{
		/// Initiliaze the protected variables
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
		
		/// Copy the values
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
	}
	
}

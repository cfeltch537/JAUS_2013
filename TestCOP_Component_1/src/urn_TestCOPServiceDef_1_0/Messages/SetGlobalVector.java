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

public class SetGlobalVector extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0407;
	
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
			
			public SetGlobalVector.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0407;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0407;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetGlobalVector.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetGlobalVector.AppHeader assign(AppHeader value)
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
		public static class  GlobalVectorRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected int m_Speed;
			protected long m_Altitude;
			protected int m_Heading;
			protected int m_Roll;
			protected int m_Pitch;
		
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
			
			public double getSpeed()
			{
				double value;
				
				double scaleFactor = ( 327.67 - 0 ) / 65535.0;
				double bias = 0;
				
				value = m_Speed * scaleFactor + bias;
				
				return value;
			}
			
			public void setSpeed(double value)
			{
				if ((value >= 0) && (value <= 327.67))
				{
					double scaleFactor = ( 327.67 - 0 ) / 65535.0;
					double bias = 0;
					
					m_Speed= (int)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAltitudeValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getAltitude()
			{
				double value;
				
				double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
				double bias = -10000;
				
				value = m_Altitude * scaleFactor + bias;
				
				return value;
			}
			
			public void setAltitude(double value)
			{
				if ((value >= -10000) && (value <= 35000))
				{
					double scaleFactor = ( 35000 - -10000 ) / 4.294967295E9;
					double bias = -10000;
					
					m_Altitude= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isHeadingValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getHeading()
			{
				double value;
				
				double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
				double bias = -3.14159265358979323846;
				
				value = m_Heading * scaleFactor + bias;
				
				return value;
			}
			
			public void setHeading(double value)
			{
				if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
				{
					double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
					double bias = -3.14159265358979323846;
					
					m_Heading= (int)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isRollValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public double getRoll()
			{
				double value;
				
				double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
				double bias = -3.14159265358979323846;
				
				value = m_Roll * scaleFactor + bias;
				
				return value;
			}
			
			public void setRoll(double value)
			{
				if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
				{
					double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
					double bias = -3.14159265358979323846;
					
					m_Roll= (int)((value - bias) / scaleFactor);
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPitchValid()
			{
				if (checkPresenceVector(3))
				{
					return true;
				}
				return false;
			}
			
			public double getPitch()
			{
				double value;
				
				double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
				double bias = -3.14159265358979323846;
				
				value = m_Pitch * scaleFactor + bias;
				
				return value;
			}
			
			public void setPitch(double value)
			{
				if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
				{
					double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
					double bias = -3.14159265358979323846;
					
					m_Pitch= (int)((value - bias) / scaleFactor);
					setPresenceVector(3);
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
				size += JausUtils.getNumBytes("short");
				if (checkPresenceVector(0))
				{
					size += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					size += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					size += JausUtils.getNumBytes("short");
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
				bytes.putShort(pos, (short) m_Speed);
				pos += JausUtils.getNumBytes("short");
				if (checkPresenceVector(0))
				{
					bytes.putInt(pos, (int) m_Altitude);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					bytes.putShort(pos, (short) m_Heading);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					bytes.putShort(pos, (short) m_Roll);
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					bytes.putShort(pos, (short) m_Pitch);
					pos += JausUtils.getNumBytes("short");
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
				m_Speed = bytes.getShort(pos) & 0xffff;
				pos += JausUtils.getNumBytes("short");
				if (checkPresenceVector(0))
				{
					m_Altitude = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					m_Heading = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(2))
				{
					m_Roll = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				if (checkPresenceVector(3))
				{
					m_Pitch = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
			}
			
			public SetGlobalVector.Body.GlobalVectorRec assign(GlobalVectorRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_Speed = value.m_Speed;
				m_Altitude = value.m_Altitude;
				m_Heading = value.m_Heading;
				m_Roll = value.m_Roll;
				m_Pitch = value.m_Pitch;
				
				return this;
			}
			
			public boolean isEqual(GlobalVectorRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_Speed != value.getSpeed())
				{
					return false;
				}
				if (m_Altitude != value.getAltitude())
				{
					return false;
				}
				if (m_Heading != value.getHeading())
				{
					return false;
				}
				if (m_Roll != value.getRoll())
				{
					return false;
				}
				if (m_Pitch != value.getPitch())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(GlobalVectorRec value)
			{
				return !this.isEqual(value);
			}
			
			public GlobalVectorRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Speed = 0;
				m_Altitude = 0;
				m_Heading = 0;
				m_Roll = 0;
				m_Pitch = 0;
			}
			
			public GlobalVectorRec(GlobalVectorRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_Speed = 0;
				m_Altitude = 0;
				m_Heading = 0;
				m_Roll = 0;
				m_Pitch = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_Speed = value.m_Speed;
				m_Altitude = value.m_Altitude;
				m_Heading = value.m_Heading;
				m_Roll = value.m_Roll;
				m_Pitch = value.m_Pitch;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected GlobalVectorRec m_GlobalVectorRec;
	
		public SetGlobalVector.Body.GlobalVectorRec getGlobalVectorRec()
		{
			return m_GlobalVectorRec;
		}
		
		public void setGlobalVectorRec(GlobalVectorRec value)
		{
			m_GlobalVectorRec = value;
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
			
			size += m_GlobalVectorRec.getSize();
			
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
			
			m_GlobalVectorRec.encode(bytes, pos);
			pos += m_GlobalVectorRec.getSize();
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
			
			m_GlobalVectorRec.decode(bytes, pos);
			pos += m_GlobalVectorRec.getSize();
		}
		
		public SetGlobalVector.Body assign(Body value)
		{
			m_GlobalVectorRec = value.m_GlobalVectorRec;
			m_GlobalVectorRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_GlobalVectorRec.isEqual(value.getGlobalVectorRec()))
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
			m_GlobalVectorRec = new GlobalVectorRec();
			m_GlobalVectorRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_GlobalVectorRec = new GlobalVectorRec();
			m_GlobalVectorRec.setParent(this);
			
			/// Copy the values
			m_GlobalVectorRec = value.m_GlobalVectorRec;
			m_GlobalVectorRec.setParent(this);
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
	public SetGlobalVector.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetGlobalVector.Body getBody()
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
	
	public SetGlobalVector setAs(SetGlobalVector value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetGlobalVector value)
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
	
	public boolean notEquals(SetGlobalVector value)
	{
		return !isEqual(value);
	}
	
	public SetGlobalVector()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetGlobalVector(SetGlobalVector value)
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

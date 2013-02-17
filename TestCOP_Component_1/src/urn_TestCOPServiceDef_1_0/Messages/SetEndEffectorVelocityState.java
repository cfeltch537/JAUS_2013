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

public class SetEndEffectorVelocityState extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0612;
	
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
			
			public SetEndEffectorVelocityState.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0612;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0612;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetEndEffectorVelocityState.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetEndEffectorVelocityState.AppHeader assign(AppHeader value)
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
		public static class  EndEffectorVelocityRec
		{
		
			protected Body m_parent;
			protected long m_AngularVelocityComponentX;
			protected long m_AngularVelocityComponentY;
			protected long m_AngularVelocityComponentZ;
			protected long m_LinearVelocityComponentX;
			protected long m_LinearVelocityComponentY;
			protected long m_LinearVelocityComponentZ;
		
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
			
			public double getAngularVelocityComponentX()
			{
				double value;
				
				double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
				double bias = -62.83185307179586;
				
				value = m_AngularVelocityComponentX * scaleFactor + bias;
				
				return value;
			}
			
			public void setAngularVelocityComponentX(double value)
			{
				if ((value >= -62.83185307179586) && (value <= 62.83185307179586))
				{
					double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
					double bias = -62.83185307179586;
					
					m_AngularVelocityComponentX= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getAngularVelocityComponentY()
			{
				double value;
				
				double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
				double bias = -62.83185307179586;
				
				value = m_AngularVelocityComponentY * scaleFactor + bias;
				
				return value;
			}
			
			public void setAngularVelocityComponentY(double value)
			{
				if ((value >= -62.83185307179586) && (value <= 62.83185307179586))
				{
					double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
					double bias = -62.83185307179586;
					
					m_AngularVelocityComponentY= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getAngularVelocityComponentZ()
			{
				double value;
				
				double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
				double bias = -62.83185307179586;
				
				value = m_AngularVelocityComponentZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setAngularVelocityComponentZ(double value)
			{
				if ((value >= -62.83185307179586) && (value <= 62.83185307179586))
				{
					double scaleFactor = ( 62.83185307179586 - -62.83185307179586 ) / 4.294967295E9;
					double bias = -62.83185307179586;
					
					m_AngularVelocityComponentZ= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getLinearVelocityComponentX()
			{
				double value;
				
				double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
				double bias = -10;
				
				value = m_LinearVelocityComponentX * scaleFactor + bias;
				
				return value;
			}
			
			public void setLinearVelocityComponentX(double value)
			{
				if ((value >= -10) && (value <= 10))
				{
					double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
					double bias = -10;
					
					m_LinearVelocityComponentX= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getLinearVelocityComponentY()
			{
				double value;
				
				double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
				double bias = -10;
				
				value = m_LinearVelocityComponentY * scaleFactor + bias;
				
				return value;
			}
			
			public void setLinearVelocityComponentY(double value)
			{
				if ((value >= -10) && (value <= 10))
				{
					double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
					double bias = -10;
					
					m_LinearVelocityComponentY= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getLinearVelocityComponentZ()
			{
				double value;
				
				double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
				double bias = -10;
				
				value = m_LinearVelocityComponentZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setLinearVelocityComponentZ(double value)
			{
				if ((value >= -10) && (value <= 10))
				{
					double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
					double bias = -10;
					
					m_LinearVelocityComponentZ= (long)((value - bias) / scaleFactor);
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
				
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
				size += JausUtils.getNumBytes("int");
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
				
				bytes.putInt(pos, (int) m_AngularVelocityComponentX);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_AngularVelocityComponentY);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_AngularVelocityComponentZ);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_LinearVelocityComponentX);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_LinearVelocityComponentY);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_LinearVelocityComponentZ);
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
				
				m_AngularVelocityComponentX = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_AngularVelocityComponentY = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_AngularVelocityComponentZ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_LinearVelocityComponentX = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_LinearVelocityComponentY = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_LinearVelocityComponentZ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
			}
			
			public SetEndEffectorVelocityState.Body.EndEffectorVelocityRec assign(EndEffectorVelocityRec value)
			{
				m_AngularVelocityComponentX = value.m_AngularVelocityComponentX;
				m_AngularVelocityComponentY = value.m_AngularVelocityComponentY;
				m_AngularVelocityComponentZ = value.m_AngularVelocityComponentZ;
				m_LinearVelocityComponentX = value.m_LinearVelocityComponentX;
				m_LinearVelocityComponentY = value.m_LinearVelocityComponentY;
				m_LinearVelocityComponentZ = value.m_LinearVelocityComponentZ;
				
				return this;
			}
			
			public boolean isEqual(EndEffectorVelocityRec value)
			{
				if (m_AngularVelocityComponentX != value.getAngularVelocityComponentX())
				{
					return false;
				}
				if (m_AngularVelocityComponentY != value.getAngularVelocityComponentY())
				{
					return false;
				}
				if (m_AngularVelocityComponentZ != value.getAngularVelocityComponentZ())
				{
					return false;
				}
				if (m_LinearVelocityComponentX != value.getLinearVelocityComponentX())
				{
					return false;
				}
				if (m_LinearVelocityComponentY != value.getLinearVelocityComponentY())
				{
					return false;
				}
				if (m_LinearVelocityComponentZ != value.getLinearVelocityComponentZ())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(EndEffectorVelocityRec value)
			{
				return !this.isEqual(value);
			}
			
			public EndEffectorVelocityRec()
			{
				m_parent = null;
				m_AngularVelocityComponentX = 0;
				m_AngularVelocityComponentY = 0;
				m_AngularVelocityComponentZ = 0;
				m_LinearVelocityComponentX = 0;
				m_LinearVelocityComponentY = 0;
				m_LinearVelocityComponentZ = 0;
			}
			
			public EndEffectorVelocityRec(EndEffectorVelocityRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_AngularVelocityComponentX = 0;
				m_AngularVelocityComponentY = 0;
				m_AngularVelocityComponentZ = 0;
				m_LinearVelocityComponentX = 0;
				m_LinearVelocityComponentY = 0;
				m_LinearVelocityComponentZ = 0;
				
				/// Copy the values
				m_AngularVelocityComponentX = value.m_AngularVelocityComponentX;
				m_AngularVelocityComponentY = value.m_AngularVelocityComponentY;
				m_AngularVelocityComponentZ = value.m_AngularVelocityComponentZ;
				m_LinearVelocityComponentX = value.m_LinearVelocityComponentX;
				m_LinearVelocityComponentY = value.m_LinearVelocityComponentY;
				m_LinearVelocityComponentZ = value.m_LinearVelocityComponentZ;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected EndEffectorVelocityRec m_EndEffectorVelocityRec;
	
		public SetEndEffectorVelocityState.Body.EndEffectorVelocityRec getEndEffectorVelocityRec()
		{
			return m_EndEffectorVelocityRec;
		}
		
		public void setEndEffectorVelocityRec(EndEffectorVelocityRec value)
		{
			m_EndEffectorVelocityRec = value;
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
			
			size += m_EndEffectorVelocityRec.getSize();
			
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
			
			m_EndEffectorVelocityRec.encode(bytes, pos);
			pos += m_EndEffectorVelocityRec.getSize();
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
			
			m_EndEffectorVelocityRec.decode(bytes, pos);
			pos += m_EndEffectorVelocityRec.getSize();
		}
		
		public SetEndEffectorVelocityState.Body assign(Body value)
		{
			m_EndEffectorVelocityRec = value.m_EndEffectorVelocityRec;
			m_EndEffectorVelocityRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_EndEffectorVelocityRec.isEqual(value.getEndEffectorVelocityRec()))
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
			m_EndEffectorVelocityRec = new EndEffectorVelocityRec();
			m_EndEffectorVelocityRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_EndEffectorVelocityRec = new EndEffectorVelocityRec();
			m_EndEffectorVelocityRec.setParent(this);
			
			/// Copy the values
			m_EndEffectorVelocityRec = value.m_EndEffectorVelocityRec;
			m_EndEffectorVelocityRec.setParent(this);
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
	public SetEndEffectorVelocityState.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetEndEffectorVelocityState.Body getBody()
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
	
	public SetEndEffectorVelocityState setAs(SetEndEffectorVelocityState value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetEndEffectorVelocityState value)
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
	
	public boolean notEquals(SetEndEffectorVelocityState value)
	{
		return !isEqual(value);
	}
	
	public SetEndEffectorVelocityState()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetEndEffectorVelocityState(SetEndEffectorVelocityState value)
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

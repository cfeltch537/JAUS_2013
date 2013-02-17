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

public class SetPanTiltMotionProfile extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0627;
	
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
			
			public SetPanTiltMotionProfile.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0627;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0627;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetPanTiltMotionProfile.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetPanTiltMotionProfile.AppHeader assign(AppHeader value)
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
		public static class  PanTiltMotionProfileRec
		{
		
			protected Body m_parent;
			protected long m_Joint1MaxSpeed;
			protected long m_Joint1MaxAccelerationRate;
			protected long m_Joint1MaxDecelerationRate;
			protected long m_Joint2MaxSpeed;
			protected long m_Joint2MaxAccelerationRate;
			protected long m_Joint2MaxDecelerationRate;
		
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
			
			public double getJoint1MaxSpeed()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint1MaxSpeed * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MaxSpeed(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint1MaxSpeed= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint1MaxAccelerationRate()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint1MaxAccelerationRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MaxAccelerationRate(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint1MaxAccelerationRate= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint1MaxDecelerationRate()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint1MaxDecelerationRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MaxDecelerationRate(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint1MaxDecelerationRate= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MaxSpeed()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint2MaxSpeed * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MaxSpeed(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint2MaxSpeed= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MaxAccelerationRate()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint2MaxAccelerationRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MaxAccelerationRate(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint2MaxAccelerationRate= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MaxDecelerationRate()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint2MaxDecelerationRate * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MaxDecelerationRate(double value)
			{
				if ((value >= 0) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint2MaxDecelerationRate= (long)((value - bias) / scaleFactor);
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
				
				bytes.putInt(pos, (int) m_Joint1MaxSpeed);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint1MaxAccelerationRate);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint1MaxDecelerationRate);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MaxSpeed);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MaxAccelerationRate);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MaxDecelerationRate);
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
				
				m_Joint1MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint1MaxAccelerationRate = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint1MaxDecelerationRate = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MaxAccelerationRate = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MaxDecelerationRate = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
			}
			
			public SetPanTiltMotionProfile.Body.PanTiltMotionProfileRec assign(PanTiltMotionProfileRec value)
			{
				m_Joint1MaxSpeed = value.m_Joint1MaxSpeed;
				m_Joint1MaxAccelerationRate = value.m_Joint1MaxAccelerationRate;
				m_Joint1MaxDecelerationRate = value.m_Joint1MaxDecelerationRate;
				m_Joint2MaxSpeed = value.m_Joint2MaxSpeed;
				m_Joint2MaxAccelerationRate = value.m_Joint2MaxAccelerationRate;
				m_Joint2MaxDecelerationRate = value.m_Joint2MaxDecelerationRate;
				
				return this;
			}
			
			public boolean isEqual(PanTiltMotionProfileRec value)
			{
				if (m_Joint1MaxSpeed != value.getJoint1MaxSpeed())
				{
					return false;
				}
				if (m_Joint1MaxAccelerationRate != value.getJoint1MaxAccelerationRate())
				{
					return false;
				}
				if (m_Joint1MaxDecelerationRate != value.getJoint1MaxDecelerationRate())
				{
					return false;
				}
				if (m_Joint2MaxSpeed != value.getJoint2MaxSpeed())
				{
					return false;
				}
				if (m_Joint2MaxAccelerationRate != value.getJoint2MaxAccelerationRate())
				{
					return false;
				}
				if (m_Joint2MaxDecelerationRate != value.getJoint2MaxDecelerationRate())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(PanTiltMotionProfileRec value)
			{
				return !this.isEqual(value);
			}
			
			public PanTiltMotionProfileRec()
			{
				m_parent = null;
				m_Joint1MaxSpeed = 0;
				m_Joint1MaxAccelerationRate = 0;
				m_Joint1MaxDecelerationRate = 0;
				m_Joint2MaxSpeed = 0;
				m_Joint2MaxAccelerationRate = 0;
				m_Joint2MaxDecelerationRate = 0;
			}
			
			public PanTiltMotionProfileRec(PanTiltMotionProfileRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_Joint1MaxSpeed = 0;
				m_Joint1MaxAccelerationRate = 0;
				m_Joint1MaxDecelerationRate = 0;
				m_Joint2MaxSpeed = 0;
				m_Joint2MaxAccelerationRate = 0;
				m_Joint2MaxDecelerationRate = 0;
				
				/// Copy the values
				m_Joint1MaxSpeed = value.m_Joint1MaxSpeed;
				m_Joint1MaxAccelerationRate = value.m_Joint1MaxAccelerationRate;
				m_Joint1MaxDecelerationRate = value.m_Joint1MaxDecelerationRate;
				m_Joint2MaxSpeed = value.m_Joint2MaxSpeed;
				m_Joint2MaxAccelerationRate = value.m_Joint2MaxAccelerationRate;
				m_Joint2MaxDecelerationRate = value.m_Joint2MaxDecelerationRate;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected PanTiltMotionProfileRec m_PanTiltMotionProfileRec;
	
		public SetPanTiltMotionProfile.Body.PanTiltMotionProfileRec getPanTiltMotionProfileRec()
		{
			return m_PanTiltMotionProfileRec;
		}
		
		public void setPanTiltMotionProfileRec(PanTiltMotionProfileRec value)
		{
			m_PanTiltMotionProfileRec = value;
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
			
			size += m_PanTiltMotionProfileRec.getSize();
			
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
			
			m_PanTiltMotionProfileRec.encode(bytes, pos);
			pos += m_PanTiltMotionProfileRec.getSize();
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
			
			m_PanTiltMotionProfileRec.decode(bytes, pos);
			pos += m_PanTiltMotionProfileRec.getSize();
		}
		
		public SetPanTiltMotionProfile.Body assign(Body value)
		{
			m_PanTiltMotionProfileRec = value.m_PanTiltMotionProfileRec;
			m_PanTiltMotionProfileRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_PanTiltMotionProfileRec.isEqual(value.getPanTiltMotionProfileRec()))
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
			m_PanTiltMotionProfileRec = new PanTiltMotionProfileRec();
			m_PanTiltMotionProfileRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_PanTiltMotionProfileRec = new PanTiltMotionProfileRec();
			m_PanTiltMotionProfileRec.setParent(this);
			
			/// Copy the values
			m_PanTiltMotionProfileRec = value.m_PanTiltMotionProfileRec;
			m_PanTiltMotionProfileRec.setParent(this);
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
	public SetPanTiltMotionProfile.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetPanTiltMotionProfile.Body getBody()
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
	
	public SetPanTiltMotionProfile setAs(SetPanTiltMotionProfile value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetPanTiltMotionProfile value)
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
	
	public boolean notEquals(SetPanTiltMotionProfile value)
	{
		return !isEqual(value);
	}
	
	public SetPanTiltMotionProfile()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetPanTiltMotionProfile(SetPanTiltMotionProfile value)
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

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

public class ReportPanTiltJointVelocities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4623;
	
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
			
			public ReportPanTiltJointVelocities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4623;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4623;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportPanTiltJointVelocities.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportPanTiltJointVelocities.AppHeader assign(AppHeader value)
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
		public static class  PanTiltJointVelocitiesRec
		{
		
			protected Body m_parent;
			protected long m_Joint1Velocity;
			protected long m_Joint2Velocity;
		
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
			
			public double getJoint1Velocity()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
				double bias = -31.41592653589793;
				
				value = m_Joint1Velocity * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1Velocity(double value)
			{
				if ((value >= -31.41592653589793) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
					double bias = -31.41592653589793;
					
					m_Joint1Velocity= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2Velocity()
			{
				double value;
				
				double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
				double bias = -31.41592653589793;
				
				value = m_Joint2Velocity * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2Velocity(double value)
			{
				if ((value >= -31.41592653589793) && (value <= 31.41592653589793))
				{
					double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
					double bias = -31.41592653589793;
					
					m_Joint2Velocity= (long)((value - bias) / scaleFactor);
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
				
				bytes.putInt(pos, (int) m_Joint1Velocity);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2Velocity);
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
				
				m_Joint1Velocity = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2Velocity = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
			}
			
			public ReportPanTiltJointVelocities.Body.PanTiltJointVelocitiesRec assign(PanTiltJointVelocitiesRec value)
			{
				m_Joint1Velocity = value.m_Joint1Velocity;
				m_Joint2Velocity = value.m_Joint2Velocity;
				
				return this;
			}
			
			public boolean isEqual(PanTiltJointVelocitiesRec value)
			{
				if (m_Joint1Velocity != value.getJoint1Velocity())
				{
					return false;
				}
				if (m_Joint2Velocity != value.getJoint2Velocity())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(PanTiltJointVelocitiesRec value)
			{
				return !this.isEqual(value);
			}
			
			public PanTiltJointVelocitiesRec()
			{
				m_parent = null;
				m_Joint1Velocity = 0;
				m_Joint2Velocity = 0;
			}
			
			public PanTiltJointVelocitiesRec(PanTiltJointVelocitiesRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_Joint1Velocity = 0;
				m_Joint2Velocity = 0;
				
				/// Copy the values
				m_Joint1Velocity = value.m_Joint1Velocity;
				m_Joint2Velocity = value.m_Joint2Velocity;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected PanTiltJointVelocitiesRec m_PanTiltJointVelocitiesRec;
	
		public ReportPanTiltJointVelocities.Body.PanTiltJointVelocitiesRec getPanTiltJointVelocitiesRec()
		{
			return m_PanTiltJointVelocitiesRec;
		}
		
		public void setPanTiltJointVelocitiesRec(PanTiltJointVelocitiesRec value)
		{
			m_PanTiltJointVelocitiesRec = value;
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
			
			size += m_PanTiltJointVelocitiesRec.getSize();
			
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
			
			m_PanTiltJointVelocitiesRec.encode(bytes, pos);
			pos += m_PanTiltJointVelocitiesRec.getSize();
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
			
			m_PanTiltJointVelocitiesRec.decode(bytes, pos);
			pos += m_PanTiltJointVelocitiesRec.getSize();
		}
		
		public ReportPanTiltJointVelocities.Body assign(Body value)
		{
			m_PanTiltJointVelocitiesRec = value.m_PanTiltJointVelocitiesRec;
			m_PanTiltJointVelocitiesRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_PanTiltJointVelocitiesRec.isEqual(value.getPanTiltJointVelocitiesRec()))
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
			m_PanTiltJointVelocitiesRec = new PanTiltJointVelocitiesRec();
			m_PanTiltJointVelocitiesRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_PanTiltJointVelocitiesRec = new PanTiltJointVelocitiesRec();
			m_PanTiltJointVelocitiesRec.setParent(this);
			
			/// Copy the values
			m_PanTiltJointVelocitiesRec = value.m_PanTiltJointVelocitiesRec;
			m_PanTiltJointVelocitiesRec.setParent(this);
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
	public ReportPanTiltJointVelocities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportPanTiltJointVelocities.Body getBody()
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
	
	public ReportPanTiltJointVelocities setAs(ReportPanTiltJointVelocities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportPanTiltJointVelocities value)
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
	
	public boolean notEquals(ReportPanTiltJointVelocities value)
	{
		return !isEqual(value);
	}
	
	public ReportPanTiltJointVelocities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportPanTiltJointVelocities(ReportPanTiltJointVelocities value)
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

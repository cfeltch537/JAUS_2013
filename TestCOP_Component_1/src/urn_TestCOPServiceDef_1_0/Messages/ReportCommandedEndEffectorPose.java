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

public class ReportCommandedEndEffectorPose extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4610;
	
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
			
			public ReportCommandedEndEffectorPose.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4610;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4610;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportCommandedEndEffectorPose.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportCommandedEndEffectorPose.AppHeader assign(AppHeader value)
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
		public static class  EndEffectorPoseRec
		{
		
			protected Body m_parent;
			protected long m_ToolPointCoordinateX;
			protected long m_ToolPointCoordinateY;
			protected long m_ToolPointCoordinateZ;
			protected long m_DComponentOfUnitQuaternionQ;
			protected long m_AComponentOfUnitQuaternionQ;
			protected long m_BComponentOfUnitQuaternionQ;
			protected long m_CComponentOfUnitQuaternionQ;
		
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
			
			public double getToolPointCoordinateX()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_ToolPointCoordinateX * scaleFactor + bias;
				
				return value;
			}
			
			public void setToolPointCoordinateX(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_ToolPointCoordinateX= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getToolPointCoordinateY()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_ToolPointCoordinateY * scaleFactor + bias;
				
				return value;
			}
			
			public void setToolPointCoordinateY(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_ToolPointCoordinateY= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getToolPointCoordinateZ()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_ToolPointCoordinateZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setToolPointCoordinateZ(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_ToolPointCoordinateZ= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getDComponentOfUnitQuaternionQ()
			{
				double value;
				
				double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
				double bias = -1;
				
				value = m_DComponentOfUnitQuaternionQ * scaleFactor + bias;
				
				return value;
			}
			
			public void setDComponentOfUnitQuaternionQ(double value)
			{
				if ((value >= -1) && (value <= 1))
				{
					double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
					double bias = -1;
					
					m_DComponentOfUnitQuaternionQ= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getAComponentOfUnitQuaternionQ()
			{
				double value;
				
				double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
				double bias = -1;
				
				value = m_AComponentOfUnitQuaternionQ * scaleFactor + bias;
				
				return value;
			}
			
			public void setAComponentOfUnitQuaternionQ(double value)
			{
				if ((value >= -1) && (value <= 1))
				{
					double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
					double bias = -1;
					
					m_AComponentOfUnitQuaternionQ= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getBComponentOfUnitQuaternionQ()
			{
				double value;
				
				double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
				double bias = -1;
				
				value = m_BComponentOfUnitQuaternionQ * scaleFactor + bias;
				
				return value;
			}
			
			public void setBComponentOfUnitQuaternionQ(double value)
			{
				if ((value >= -1) && (value <= 1))
				{
					double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
					double bias = -1;
					
					m_BComponentOfUnitQuaternionQ= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getCComponentOfUnitQuaternionQ()
			{
				double value;
				
				double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
				double bias = -1;
				
				value = m_CComponentOfUnitQuaternionQ * scaleFactor + bias;
				
				return value;
			}
			
			public void setCComponentOfUnitQuaternionQ(double value)
			{
				if ((value >= -1) && (value <= 1))
				{
					double scaleFactor = ( 1 - -1 ) / 4.294967295E9;
					double bias = -1;
					
					m_CComponentOfUnitQuaternionQ= (long)((value - bias) / scaleFactor);
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
				
				bytes.putInt(pos, (int) m_ToolPointCoordinateX);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_ToolPointCoordinateY);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_ToolPointCoordinateZ);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_DComponentOfUnitQuaternionQ);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_AComponentOfUnitQuaternionQ);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_BComponentOfUnitQuaternionQ);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_CComponentOfUnitQuaternionQ);
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
				
				m_ToolPointCoordinateX = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_ToolPointCoordinateY = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_ToolPointCoordinateZ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_DComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_AComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_BComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_CComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
			}
			
			public ReportCommandedEndEffectorPose.Body.EndEffectorPoseRec assign(EndEffectorPoseRec value)
			{
				m_ToolPointCoordinateX = value.m_ToolPointCoordinateX;
				m_ToolPointCoordinateY = value.m_ToolPointCoordinateY;
				m_ToolPointCoordinateZ = value.m_ToolPointCoordinateZ;
				m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
				m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
				m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
				m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
				
				return this;
			}
			
			public boolean isEqual(EndEffectorPoseRec value)
			{
				if (m_ToolPointCoordinateX != value.getToolPointCoordinateX())
				{
					return false;
				}
				if (m_ToolPointCoordinateY != value.getToolPointCoordinateY())
				{
					return false;
				}
				if (m_ToolPointCoordinateZ != value.getToolPointCoordinateZ())
				{
					return false;
				}
				if (m_DComponentOfUnitQuaternionQ != value.getDComponentOfUnitQuaternionQ())
				{
					return false;
				}
				if (m_AComponentOfUnitQuaternionQ != value.getAComponentOfUnitQuaternionQ())
				{
					return false;
				}
				if (m_BComponentOfUnitQuaternionQ != value.getBComponentOfUnitQuaternionQ())
				{
					return false;
				}
				if (m_CComponentOfUnitQuaternionQ != value.getCComponentOfUnitQuaternionQ())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(EndEffectorPoseRec value)
			{
				return !this.isEqual(value);
			}
			
			public EndEffectorPoseRec()
			{
				m_parent = null;
				m_ToolPointCoordinateX = 0;
				m_ToolPointCoordinateY = 0;
				m_ToolPointCoordinateZ = 0;
				m_DComponentOfUnitQuaternionQ = 0;
				m_AComponentOfUnitQuaternionQ = 0;
				m_BComponentOfUnitQuaternionQ = 0;
				m_CComponentOfUnitQuaternionQ = 0;
			}
			
			public EndEffectorPoseRec(EndEffectorPoseRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_ToolPointCoordinateX = 0;
				m_ToolPointCoordinateY = 0;
				m_ToolPointCoordinateZ = 0;
				m_DComponentOfUnitQuaternionQ = 0;
				m_AComponentOfUnitQuaternionQ = 0;
				m_BComponentOfUnitQuaternionQ = 0;
				m_CComponentOfUnitQuaternionQ = 0;
				
				/// Copy the values
				m_ToolPointCoordinateX = value.m_ToolPointCoordinateX;
				m_ToolPointCoordinateY = value.m_ToolPointCoordinateY;
				m_ToolPointCoordinateZ = value.m_ToolPointCoordinateZ;
				m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
				m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
				m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
				m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected EndEffectorPoseRec m_EndEffectorPoseRec;
	
		public ReportCommandedEndEffectorPose.Body.EndEffectorPoseRec getEndEffectorPoseRec()
		{
			return m_EndEffectorPoseRec;
		}
		
		public void setEndEffectorPoseRec(EndEffectorPoseRec value)
		{
			m_EndEffectorPoseRec = value;
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
			
			size += m_EndEffectorPoseRec.getSize();
			
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
			
			m_EndEffectorPoseRec.encode(bytes, pos);
			pos += m_EndEffectorPoseRec.getSize();
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
			
			m_EndEffectorPoseRec.decode(bytes, pos);
			pos += m_EndEffectorPoseRec.getSize();
		}
		
		public ReportCommandedEndEffectorPose.Body assign(Body value)
		{
			m_EndEffectorPoseRec = value.m_EndEffectorPoseRec;
			m_EndEffectorPoseRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_EndEffectorPoseRec.isEqual(value.getEndEffectorPoseRec()))
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
			m_EndEffectorPoseRec = new EndEffectorPoseRec();
			m_EndEffectorPoseRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_EndEffectorPoseRec = new EndEffectorPoseRec();
			m_EndEffectorPoseRec.setParent(this);
			
			/// Copy the values
			m_EndEffectorPoseRec = value.m_EndEffectorPoseRec;
			m_EndEffectorPoseRec.setParent(this);
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
	public ReportCommandedEndEffectorPose.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportCommandedEndEffectorPose.Body getBody()
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
	
	public ReportCommandedEndEffectorPose setAs(ReportCommandedEndEffectorPose value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportCommandedEndEffectorPose value)
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
	
	public boolean notEquals(ReportCommandedEndEffectorPose value)
	{
		return !isEqual(value);
	}
	
	public ReportCommandedEndEffectorPose()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportCommandedEndEffectorPose(ReportCommandedEndEffectorPose value)
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

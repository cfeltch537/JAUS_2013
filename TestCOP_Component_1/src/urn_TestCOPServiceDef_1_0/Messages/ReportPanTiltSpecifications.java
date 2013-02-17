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

public class ReportPanTiltSpecifications extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4620;
	
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
			
			public ReportPanTiltSpecifications.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4620;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4620;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportPanTiltSpecifications.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportPanTiltSpecifications.AppHeader assign(AppHeader value)
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
		public static class  ReportPanTiltSpecificationsRec
		{
		
			protected Body m_parent;
			protected BitSet m_PresenceVector;
			protected short m_PresenceVectorTemp;
			protected long m_PanTiltCoordinateSysX;
			protected long m_PanTiltCoordinateSysY;
			protected long m_PanTiltCoordinateSysZ;
			protected long m_DComponentOfUnitQuaternionQ;
			protected long m_AComponentOfUnitQuaternionQ;
			protected long m_BComponentOfUnitQuaternionQ;
			protected long m_CComponentOfUnitQuaternionQ;
			protected long m_Joint1MinValue;
			protected long m_Joint1MaxValue;
			protected long m_Joint1MaxSpeed;
			protected long m_Joint2MinValue;
			protected long m_Joint2MaxValue;
			protected long m_Joint2MaxSpeed;
		
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
			
			public boolean isPanTiltCoordinateSysXValid()
			{
				if (checkPresenceVector(0))
				{
					return true;
				}
				return false;
			}
			
			public double getPanTiltCoordinateSysX()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_PanTiltCoordinateSysX * scaleFactor + bias;
				
				return value;
			}
			
			public void setPanTiltCoordinateSysX(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_PanTiltCoordinateSysX= (long)((value - bias) / scaleFactor);
					setPresenceVector(0);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPanTiltCoordinateSysYValid()
			{
				if (checkPresenceVector(1))
				{
					return true;
				}
				return false;
			}
			
			public double getPanTiltCoordinateSysY()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_PanTiltCoordinateSysY * scaleFactor + bias;
				
				return value;
			}
			
			public void setPanTiltCoordinateSysY(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_PanTiltCoordinateSysY= (long)((value - bias) / scaleFactor);
					setPresenceVector(1);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isPanTiltCoordinateSysZValid()
			{
				if (checkPresenceVector(2))
				{
					return true;
				}
				return false;
			}
			
			public double getPanTiltCoordinateSysZ()
			{
				double value;
				
				double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
				double bias = -30;
				
				value = m_PanTiltCoordinateSysZ * scaleFactor + bias;
				
				return value;
			}
			
			public void setPanTiltCoordinateSysZ(double value)
			{
				if ((value >= -30) && (value <= 30))
				{
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					m_PanTiltCoordinateSysZ= (long)((value - bias) / scaleFactor);
					setPresenceVector(2);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isDComponentOfUnitQuaternionQValid()
			{
				if (checkPresenceVector(3))
				{
					return true;
				}
				return false;
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
					setPresenceVector(3);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isAComponentOfUnitQuaternionQValid()
			{
				if (checkPresenceVector(4))
				{
					return true;
				}
				return false;
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
					setPresenceVector(4);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isBComponentOfUnitQuaternionQValid()
			{
				if (checkPresenceVector(5))
				{
					return true;
				}
				return false;
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
					setPresenceVector(5);
					setParentPresenceVector();
				}
				return;
			}
			
			public boolean isCComponentOfUnitQuaternionQValid()
			{
				if (checkPresenceVector(6))
				{
					return true;
				}
				return false;
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
					setPresenceVector(6);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint1MinValue()
			{
				double value;
				
				double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
				double bias = -25.13274122871834590768;
				
				value = m_Joint1MinValue * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MinValue(double value)
			{
				if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
				{
					double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
					double bias = -25.13274122871834590768;
					
					m_Joint1MinValue= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint1MaxValue()
			{
				double value;
				
				double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
				double bias = -25.13274122871834590768;
				
				value = m_Joint1MaxValue * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MaxValue(double value)
			{
				if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
				{
					double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
					double bias = -25.13274122871834590768;
					
					m_Joint1MaxValue= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint1MaxSpeed()
			{
				double value;
				
				double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint1MaxSpeed * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint1MaxSpeed(double value)
			{
				if ((value >= 0) && (value <= 31.4159265358979323846))
				{
					double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint1MaxSpeed= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MinValue()
			{
				double value;
				
				double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
				double bias = -25.13274122871834590768;
				
				value = m_Joint2MinValue * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MinValue(double value)
			{
				if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
				{
					double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
					double bias = -25.13274122871834590768;
					
					m_Joint2MinValue= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MaxValue()
			{
				double value;
				
				double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
				double bias = -25.13274122871834590768;
				
				value = m_Joint2MaxValue * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MaxValue(double value)
			{
				if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
				{
					double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
					double bias = -25.13274122871834590768;
					
					m_Joint2MaxValue= (long)((value - bias) / scaleFactor);
					setParentPresenceVector();
				}
				return;
			}
			
			public double getJoint2MaxSpeed()
			{
				double value;
				
				double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
				double bias = 0;
				
				value = m_Joint2MaxSpeed * scaleFactor + bias;
				
				return value;
			}
			
			public void setJoint2MaxSpeed(double value)
			{
				if ((value >= 0) && (value <= 31.4159265358979323846))
				{
					double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
					double bias = 0;
					
					m_Joint2MaxSpeed= (long)((value - bias) / scaleFactor);
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
				if (checkPresenceVector(6))
				{
					size += JausUtils.getNumBytes("int");
				}
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
					bytes.putInt(pos, (int) m_PanTiltCoordinateSysX);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					bytes.putInt(pos, (int) m_PanTiltCoordinateSysY);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					bytes.putInt(pos, (int) m_PanTiltCoordinateSysZ);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					bytes.putInt(pos, (int) m_DComponentOfUnitQuaternionQ);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					bytes.putInt(pos, (int) m_AComponentOfUnitQuaternionQ);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(5))
				{
					bytes.putInt(pos, (int) m_BComponentOfUnitQuaternionQ);
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(6))
				{
					bytes.putInt(pos, (int) m_CComponentOfUnitQuaternionQ);
					pos += JausUtils.getNumBytes("int");
				}
				bytes.putInt(pos, (int) m_Joint1MinValue);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint1MaxValue);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint1MaxSpeed);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MinValue);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MaxValue);
				pos += JausUtils.getNumBytes("int");
				bytes.putInt(pos, (int) m_Joint2MaxSpeed);
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
					m_PanTiltCoordinateSysX = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(1))
				{
					m_PanTiltCoordinateSysY = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(2))
				{
					m_PanTiltCoordinateSysZ = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(3))
				{
					m_DComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(4))
				{
					m_AComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(5))
				{
					m_BComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				if (checkPresenceVector(6))
				{
					m_CComponentOfUnitQuaternionQ = bytes.getInt(pos) & 0xffffffffL;
					pos += JausUtils.getNumBytes("int");
				}
				m_Joint1MinValue = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint1MaxValue = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint1MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MinValue = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MaxValue = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
				m_Joint2MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
				pos += JausUtils.getNumBytes("int");
			}
			
			public ReportPanTiltSpecifications.Body.ReportPanTiltSpecificationsRec assign(ReportPanTiltSpecificationsRec value)
			{
				m_PresenceVector = value.m_PresenceVector;
				m_PanTiltCoordinateSysX = value.m_PanTiltCoordinateSysX;
				m_PanTiltCoordinateSysY = value.m_PanTiltCoordinateSysY;
				m_PanTiltCoordinateSysZ = value.m_PanTiltCoordinateSysZ;
				m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
				m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
				m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
				m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
				m_Joint1MinValue = value.m_Joint1MinValue;
				m_Joint1MaxValue = value.m_Joint1MaxValue;
				m_Joint1MaxSpeed = value.m_Joint1MaxSpeed;
				m_Joint2MinValue = value.m_Joint2MinValue;
				m_Joint2MaxValue = value.m_Joint2MaxValue;
				m_Joint2MaxSpeed = value.m_Joint2MaxSpeed;
				
				return this;
			}
			
			public boolean isEqual(ReportPanTiltSpecificationsRec value)
			{
				if (!m_PresenceVector.equals(value.m_PresenceVector))
				{
					return false;
				}
				if (m_PanTiltCoordinateSysX != value.getPanTiltCoordinateSysX())
				{
					return false;
				}
				if (m_PanTiltCoordinateSysY != value.getPanTiltCoordinateSysY())
				{
					return false;
				}
				if (m_PanTiltCoordinateSysZ != value.getPanTiltCoordinateSysZ())
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
				if (m_Joint1MinValue != value.getJoint1MinValue())
				{
					return false;
				}
				if (m_Joint1MaxValue != value.getJoint1MaxValue())
				{
					return false;
				}
				if (m_Joint1MaxSpeed != value.getJoint1MaxSpeed())
				{
					return false;
				}
				if (m_Joint2MinValue != value.getJoint2MinValue())
				{
					return false;
				}
				if (m_Joint2MaxValue != value.getJoint2MaxValue())
				{
					return false;
				}
				if (m_Joint2MaxSpeed != value.getJoint2MaxSpeed())
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ReportPanTiltSpecificationsRec value)
			{
				return !this.isEqual(value);
			}
			
			public ReportPanTiltSpecificationsRec()
			{
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_PanTiltCoordinateSysX = 0;
				m_PanTiltCoordinateSysY = 0;
				m_PanTiltCoordinateSysZ = 0;
				m_DComponentOfUnitQuaternionQ = 0;
				m_AComponentOfUnitQuaternionQ = 0;
				m_BComponentOfUnitQuaternionQ = 0;
				m_CComponentOfUnitQuaternionQ = 0;
				m_Joint1MinValue = 0;
				m_Joint1MaxValue = 0;
				m_Joint1MaxSpeed = 0;
				m_Joint2MinValue = 0;
				m_Joint2MaxValue = 0;
				m_Joint2MaxSpeed = 0;
			}
			
			public ReportPanTiltSpecificationsRec(ReportPanTiltSpecificationsRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_PresenceVector = new BitSet();
				m_PresenceVectorTemp = 0;
				m_PanTiltCoordinateSysX = 0;
				m_PanTiltCoordinateSysY = 0;
				m_PanTiltCoordinateSysZ = 0;
				m_DComponentOfUnitQuaternionQ = 0;
				m_AComponentOfUnitQuaternionQ = 0;
				m_BComponentOfUnitQuaternionQ = 0;
				m_CComponentOfUnitQuaternionQ = 0;
				m_Joint1MinValue = 0;
				m_Joint1MaxValue = 0;
				m_Joint1MaxSpeed = 0;
				m_Joint2MinValue = 0;
				m_Joint2MaxValue = 0;
				m_Joint2MaxSpeed = 0;
				
				/// Copy the values
				m_PresenceVector = value.m_PresenceVector;
				m_PanTiltCoordinateSysX = value.m_PanTiltCoordinateSysX;
				m_PanTiltCoordinateSysY = value.m_PanTiltCoordinateSysY;
				m_PanTiltCoordinateSysZ = value.m_PanTiltCoordinateSysZ;
				m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
				m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
				m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
				m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
				m_Joint1MinValue = value.m_Joint1MinValue;
				m_Joint1MaxValue = value.m_Joint1MaxValue;
				m_Joint1MaxSpeed = value.m_Joint1MaxSpeed;
				m_Joint2MinValue = value.m_Joint2MinValue;
				m_Joint2MaxValue = value.m_Joint2MaxValue;
				m_Joint2MaxSpeed = value.m_Joint2MaxSpeed;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ReportPanTiltSpecificationsRec m_ReportPanTiltSpecificationsRec;
	
		public ReportPanTiltSpecifications.Body.ReportPanTiltSpecificationsRec getReportPanTiltSpecificationsRec()
		{
			return m_ReportPanTiltSpecificationsRec;
		}
		
		public void setReportPanTiltSpecificationsRec(ReportPanTiltSpecificationsRec value)
		{
			m_ReportPanTiltSpecificationsRec = value;
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
			
			size += m_ReportPanTiltSpecificationsRec.getSize();
			
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
			
			m_ReportPanTiltSpecificationsRec.encode(bytes, pos);
			pos += m_ReportPanTiltSpecificationsRec.getSize();
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
			
			m_ReportPanTiltSpecificationsRec.decode(bytes, pos);
			pos += m_ReportPanTiltSpecificationsRec.getSize();
		}
		
		public ReportPanTiltSpecifications.Body assign(Body value)
		{
			m_ReportPanTiltSpecificationsRec = value.m_ReportPanTiltSpecificationsRec;
			m_ReportPanTiltSpecificationsRec.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ReportPanTiltSpecificationsRec.isEqual(value.getReportPanTiltSpecificationsRec()))
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
			m_ReportPanTiltSpecificationsRec = new ReportPanTiltSpecificationsRec();
			m_ReportPanTiltSpecificationsRec.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ReportPanTiltSpecificationsRec = new ReportPanTiltSpecificationsRec();
			m_ReportPanTiltSpecificationsRec.setParent(this);
			
			/// Copy the values
			m_ReportPanTiltSpecificationsRec = value.m_ReportPanTiltSpecificationsRec;
			m_ReportPanTiltSpecificationsRec.setParent(this);
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
	public ReportPanTiltSpecifications.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportPanTiltSpecifications.Body getBody()
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
	
	public ReportPanTiltSpecifications setAs(ReportPanTiltSpecifications value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportPanTiltSpecifications value)
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
	
	public boolean notEquals(ReportPanTiltSpecifications value)
	{
		return !isEqual(value);
	}
	
	public ReportPanTiltSpecifications()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportPanTiltSpecifications(ReportPanTiltSpecifications value)
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

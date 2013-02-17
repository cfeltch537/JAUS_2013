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

public class ReportManipulatorSpecifications extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4600;
	
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
			
			public ReportManipulatorSpecifications.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4600;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4600;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportManipulatorSpecifications.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportManipulatorSpecifications.AppHeader assign(AppHeader value)
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
		public static class  ReportManipulatorSpecification
		{
			public static class  ManipulatorCoordinateSystemRec
			{
			
				protected ReportManipulatorSpecification m_parent;
				protected BitSet m_PresenceVector;
				protected short m_PresenceVectorTemp;
				protected long m_ManipulatorCoordinateSysX;
				protected long m_ManipulatorCoordinateSysY;
				protected long m_ManipulatorCoordinateSysZ;
				protected long m_DComponentOfUnitQuaternionQ;
				protected long m_AComponentOfUnitQuaternionQ;
				protected long m_BComponentOfUnitQuaternionQ;
				protected long m_CComponentOfUnitQuaternionQ;
			
				public void setParent(ReportManipulatorSpecification parent)
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
				
				public boolean isManipulatorCoordinateSysXValid()
				{
					if (checkPresenceVector(0))
					{
						return true;
					}
					return false;
				}
				
				public double getManipulatorCoordinateSysX()
				{
					double value;
					
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					value = m_ManipulatorCoordinateSysX * scaleFactor + bias;
					
					return value;
				}
				
				public void setManipulatorCoordinateSysX(double value)
				{
					if ((value >= -30) && (value <= 30))
					{
						double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
						double bias = -30;
						
						m_ManipulatorCoordinateSysX= (long)((value - bias) / scaleFactor);
						setPresenceVector(0);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isManipulatorCoordinateSysYValid()
				{
					if (checkPresenceVector(1))
					{
						return true;
					}
					return false;
				}
				
				public double getManipulatorCoordinateSysY()
				{
					double value;
					
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					value = m_ManipulatorCoordinateSysY * scaleFactor + bias;
					
					return value;
				}
				
				public void setManipulatorCoordinateSysY(double value)
				{
					if ((value >= -30) && (value <= 30))
					{
						double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
						double bias = -30;
						
						m_ManipulatorCoordinateSysY= (long)((value - bias) / scaleFactor);
						setPresenceVector(1);
						setParentPresenceVector();
					}
					return;
				}
				
				public boolean isManipulatorCoordinateSysZValid()
				{
					if (checkPresenceVector(2))
					{
						return true;
					}
					return false;
				}
				
				public double getManipulatorCoordinateSysZ()
				{
					double value;
					
					double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
					double bias = -30;
					
					value = m_ManipulatorCoordinateSysZ * scaleFactor + bias;
					
					return value;
				}
				
				public void setManipulatorCoordinateSysZ(double value)
				{
					if ((value >= -30) && (value <= 30))
					{
						double scaleFactor = ( 30 - -30 ) / 4.294967295E9;
						double bias = -30;
						
						m_ManipulatorCoordinateSysZ= (long)((value - bias) / scaleFactor);
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
						bytes.putInt(pos, (int) m_ManipulatorCoordinateSysX);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(1))
					{
						bytes.putInt(pos, (int) m_ManipulatorCoordinateSysY);
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						bytes.putInt(pos, (int) m_ManipulatorCoordinateSysZ);
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
						m_ManipulatorCoordinateSysX = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(1))
					{
						m_ManipulatorCoordinateSysY = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					if (checkPresenceVector(2))
					{
						m_ManipulatorCoordinateSysZ = bytes.getInt(pos) & 0xffffffffL;
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
				}
				
				public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.ManipulatorCoordinateSystemRec assign(ManipulatorCoordinateSystemRec value)
				{
					m_PresenceVector = value.m_PresenceVector;
					m_ManipulatorCoordinateSysX = value.m_ManipulatorCoordinateSysX;
					m_ManipulatorCoordinateSysY = value.m_ManipulatorCoordinateSysY;
					m_ManipulatorCoordinateSysZ = value.m_ManipulatorCoordinateSysZ;
					m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
					m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
					m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
					m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
					
					return this;
				}
				
				public boolean isEqual(ManipulatorCoordinateSystemRec value)
				{
					if (!m_PresenceVector.equals(value.m_PresenceVector))
					{
						return false;
					}
					if (m_ManipulatorCoordinateSysX != value.getManipulatorCoordinateSysX())
					{
						return false;
					}
					if (m_ManipulatorCoordinateSysY != value.getManipulatorCoordinateSysY())
					{
						return false;
					}
					if (m_ManipulatorCoordinateSysZ != value.getManipulatorCoordinateSysZ())
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
				
				public boolean notEquals(ManipulatorCoordinateSystemRec value)
				{
					return !this.isEqual(value);
				}
				
				public ManipulatorCoordinateSystemRec()
				{
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_ManipulatorCoordinateSysX = 0;
					m_ManipulatorCoordinateSysY = 0;
					m_ManipulatorCoordinateSysZ = 0;
					m_DComponentOfUnitQuaternionQ = 0;
					m_AComponentOfUnitQuaternionQ = 0;
					m_BComponentOfUnitQuaternionQ = 0;
					m_CComponentOfUnitQuaternionQ = 0;
				}
				
				public ManipulatorCoordinateSystemRec(ManipulatorCoordinateSystemRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_PresenceVector = new BitSet();
					m_PresenceVectorTemp = 0;
					m_ManipulatorCoordinateSysX = 0;
					m_ManipulatorCoordinateSysY = 0;
					m_ManipulatorCoordinateSysZ = 0;
					m_DComponentOfUnitQuaternionQ = 0;
					m_AComponentOfUnitQuaternionQ = 0;
					m_BComponentOfUnitQuaternionQ = 0;
					m_CComponentOfUnitQuaternionQ = 0;
					
					/// Copy the values
					m_PresenceVector = value.m_PresenceVector;
					m_ManipulatorCoordinateSysX = value.m_ManipulatorCoordinateSysX;
					m_ManipulatorCoordinateSysY = value.m_ManipulatorCoordinateSysY;
					m_ManipulatorCoordinateSysZ = value.m_ManipulatorCoordinateSysZ;
					m_DComponentOfUnitQuaternionQ = value.m_DComponentOfUnitQuaternionQ;
					m_AComponentOfUnitQuaternionQ = value.m_AComponentOfUnitQuaternionQ;
					m_BComponentOfUnitQuaternionQ = value.m_BComponentOfUnitQuaternionQ;
					m_CComponentOfUnitQuaternionQ = value.m_CComponentOfUnitQuaternionQ;
				}
				
				public void finalize()
				{
				}
				
			}
			public static class  JointSpecificationList
			{
				public static class  JointSpecifications
				{
					public static class  RevoluteJointSpecificationRec
					{
					
						protected JointSpecifications m_parent;
						protected short m_LinkLength;
						protected int m_TwistAngle;
						protected short m_JointOffset;
						protected long m_MinValue;
						protected long m_MaxValue;
						protected long m_MaxSpeed;
					
						public void setParent(JointSpecifications parent)
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
						
						public double getLinkLength()
						{
							double value;
							
							double scaleFactor = ( 10 - -10 ) / 32767.0;
							double bias = -10;
							
							value = m_LinkLength * scaleFactor + bias;
							
							return value;
						}
						
						public void setLinkLength(double value)
						{
							if ((value >= -10) && (value <= 10))
							{
								double scaleFactor = ( 10 - -10 ) / 32767.0;
								double bias = -10;
								
								m_LinkLength= (short)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getTwistAngle()
						{
							double value;
							
							double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
							double bias = -3.14159265358979323846;
							
							value = m_TwistAngle * scaleFactor + bias;
							
							return value;
						}
						
						public void setTwistAngle(double value)
						{
							if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
							{
								double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
								double bias = -3.14159265358979323846;
								
								m_TwistAngle= (int)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getJointOffset()
						{
							double value;
							
							double scaleFactor = ( 10 - -10 ) / 32767.0;
							double bias = -10;
							
							value = m_JointOffset * scaleFactor + bias;
							
							return value;
						}
						
						public void setJointOffset(double value)
						{
							if ((value >= -10) && (value <= 10))
							{
								double scaleFactor = ( 10 - -10 ) / 32767.0;
								double bias = -10;
								
								m_JointOffset= (short)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMinValue()
						{
							double value;
							
							double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
							double bias = -25.13274122871834590768;
							
							value = m_MinValue * scaleFactor + bias;
							
							return value;
						}
						
						public void setMinValue(double value)
						{
							if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
							{
								double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
								double bias = -25.13274122871834590768;
								
								m_MinValue= (long)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMaxValue()
						{
							double value;
							
							double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
							double bias = -25.13274122871834590768;
							
							value = m_MaxValue * scaleFactor + bias;
							
							return value;
						}
						
						public void setMaxValue(double value)
						{
							if ((value >= -25.13274122871834590768) && (value <= 25.13274122871834590768))
							{
								double scaleFactor = ( 25.13274122871834590768 - -25.13274122871834590768 ) / 4.294967295E9;
								double bias = -25.13274122871834590768;
								
								m_MaxValue= (long)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMaxSpeed()
						{
							double value;
							
							double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							value = m_MaxSpeed * scaleFactor + bias;
							
							return value;
						}
						
						public void setMaxSpeed(double value)
						{
							if ((value >= 0) && (value <= 31.4159265358979323846))
							{
								double scaleFactor = ( 31.4159265358979323846 - 0 ) / 4.294967295E9;
								double bias = 0;
								
								m_MaxSpeed= (long)((value - bias) / scaleFactor);
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
							
							size += JausUtils.getNumBytes("short");
							size += JausUtils.getNumBytes("short");
							size += JausUtils.getNumBytes("short");
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
							
							bytes.putShort(pos, m_LinkLength);
							pos += JausUtils.getNumBytes("short");
							bytes.putShort(pos, (short) m_TwistAngle);
							pos += JausUtils.getNumBytes("short");
							bytes.putShort(pos, m_JointOffset);
							pos += JausUtils.getNumBytes("short");
							bytes.putInt(pos, (int) m_MinValue);
							pos += JausUtils.getNumBytes("int");
							bytes.putInt(pos, (int) m_MaxValue);
							pos += JausUtils.getNumBytes("int");
							bytes.putInt(pos, (int) m_MaxSpeed);
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
							
							m_LinkLength = bytes.getShort(pos);
							pos += JausUtils.getNumBytes("short");
							m_TwistAngle = bytes.getShort(pos) & 0xffff;
							pos += JausUtils.getNumBytes("short");
							m_JointOffset = bytes.getShort(pos);
							pos += JausUtils.getNumBytes("short");
							m_MinValue = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
							m_MaxValue = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
							m_MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
						}
						
						public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications.RevoluteJointSpecificationRec assign(RevoluteJointSpecificationRec value)
						{
							m_LinkLength = value.m_LinkLength;
							m_TwistAngle = value.m_TwistAngle;
							m_JointOffset = value.m_JointOffset;
							m_MinValue = value.m_MinValue;
							m_MaxValue = value.m_MaxValue;
							m_MaxSpeed = value.m_MaxSpeed;
							
							return this;
						}
						
						public boolean isEqual(RevoluteJointSpecificationRec value)
						{
							if (m_LinkLength != value.getLinkLength())
							{
								return false;
							}
							if (m_TwistAngle != value.getTwistAngle())
							{
								return false;
							}
							if (m_JointOffset != value.getJointOffset())
							{
								return false;
							}
							if (m_MinValue != value.getMinValue())
							{
								return false;
							}
							if (m_MaxValue != value.getMaxValue())
							{
								return false;
							}
							if (m_MaxSpeed != value.getMaxSpeed())
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(RevoluteJointSpecificationRec value)
						{
							return !this.isEqual(value);
						}
						
						public RevoluteJointSpecificationRec()
						{
							m_parent = null;
							m_LinkLength = 0;
							m_TwistAngle = 0;
							m_JointOffset = 0;
							m_MinValue = 0;
							m_MaxValue = 0;
							m_MaxSpeed = 0;
						}
						
						public RevoluteJointSpecificationRec(RevoluteJointSpecificationRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_LinkLength = 0;
							m_TwistAngle = 0;
							m_JointOffset = 0;
							m_MinValue = 0;
							m_MaxValue = 0;
							m_MaxSpeed = 0;
							
							/// Copy the values
							m_LinkLength = value.m_LinkLength;
							m_TwistAngle = value.m_TwistAngle;
							m_JointOffset = value.m_JointOffset;
							m_MinValue = value.m_MinValue;
							m_MaxValue = value.m_MaxValue;
							m_MaxSpeed = value.m_MaxSpeed;
						}
						
						public void finalize()
						{
						}
						
					}
					public static class  PrismaticJointSpecificationRec
					{
					
						protected JointSpecifications m_parent;
						protected short m_LinkLength;
						protected int m_TwistAngle;
						protected int m_JointAngle;
						protected long m_MinValue;
						protected long m_MaxValue;
						protected long m_MaxSpeed;
					
						public void setParent(JointSpecifications parent)
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
						
						public double getLinkLength()
						{
							double value;
							
							double scaleFactor = ( 10 - -10 ) / 32767.0;
							double bias = -10;
							
							value = m_LinkLength * scaleFactor + bias;
							
							return value;
						}
						
						public void setLinkLength(double value)
						{
							if ((value >= -10) && (value <= 10))
							{
								double scaleFactor = ( 10 - -10 ) / 32767.0;
								double bias = -10;
								
								m_LinkLength= (short)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getTwistAngle()
						{
							double value;
							
							double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
							double bias = -3.14159265358979323846;
							
							value = m_TwistAngle * scaleFactor + bias;
							
							return value;
						}
						
						public void setTwistAngle(double value)
						{
							if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
							{
								double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
								double bias = -3.14159265358979323846;
								
								m_TwistAngle= (int)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getJointAngle()
						{
							double value;
							
							double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
							double bias = -3.14159265358979323846;
							
							value = m_JointAngle * scaleFactor + bias;
							
							return value;
						}
						
						public void setJointAngle(double value)
						{
							if ((value >= -3.14159265358979323846) && (value <= 3.14159265358979323846))
							{
								double scaleFactor = ( 3.14159265358979323846 - -3.14159265358979323846 ) / 65535.0;
								double bias = -3.14159265358979323846;
								
								m_JointAngle= (int)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMinValue()
						{
							double value;
							
							double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
							double bias = -10;
							
							value = m_MinValue * scaleFactor + bias;
							
							return value;
						}
						
						public void setMinValue(double value)
						{
							if ((value >= -10) && (value <= 10))
							{
								double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
								double bias = -10;
								
								m_MinValue= (long)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMaxValue()
						{
							double value;
							
							double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
							double bias = -10;
							
							value = m_MaxValue * scaleFactor + bias;
							
							return value;
						}
						
						public void setMaxValue(double value)
						{
							if ((value >= -10) && (value <= 10))
							{
								double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
								double bias = -10;
								
								m_MaxValue= (long)((value - bias) / scaleFactor);
								setParentPresenceVector();
							}
							return;
						}
						
						public double getMaxSpeed()
						{
							double value;
							
							double scaleFactor = ( 5 - -5 ) / 4.294967295E9;
							double bias = -5;
							
							value = m_MaxSpeed * scaleFactor + bias;
							
							return value;
						}
						
						public void setMaxSpeed(double value)
						{
							if ((value >= -5) && (value <= 5))
							{
								double scaleFactor = ( 5 - -5 ) / 4.294967295E9;
								double bias = -5;
								
								m_MaxSpeed= (long)((value - bias) / scaleFactor);
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
							
							size += JausUtils.getNumBytes("short");
							size += JausUtils.getNumBytes("short");
							size += JausUtils.getNumBytes("short");
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
							
							bytes.putShort(pos, m_LinkLength);
							pos += JausUtils.getNumBytes("short");
							bytes.putShort(pos, (short) m_TwistAngle);
							pos += JausUtils.getNumBytes("short");
							bytes.putShort(pos, (short) m_JointAngle);
							pos += JausUtils.getNumBytes("short");
							bytes.putInt(pos, (int) m_MinValue);
							pos += JausUtils.getNumBytes("int");
							bytes.putInt(pos, (int) m_MaxValue);
							pos += JausUtils.getNumBytes("int");
							bytes.putInt(pos, (int) m_MaxSpeed);
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
							
							m_LinkLength = bytes.getShort(pos);
							pos += JausUtils.getNumBytes("short");
							m_TwistAngle = bytes.getShort(pos) & 0xffff;
							pos += JausUtils.getNumBytes("short");
							m_JointAngle = bytes.getShort(pos) & 0xffff;
							pos += JausUtils.getNumBytes("short");
							m_MinValue = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
							m_MaxValue = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
							m_MaxSpeed = bytes.getInt(pos) & 0xffffffffL;
							pos += JausUtils.getNumBytes("int");
						}
						
						public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications.PrismaticJointSpecificationRec assign(PrismaticJointSpecificationRec value)
						{
							m_LinkLength = value.m_LinkLength;
							m_TwistAngle = value.m_TwistAngle;
							m_JointAngle = value.m_JointAngle;
							m_MinValue = value.m_MinValue;
							m_MaxValue = value.m_MaxValue;
							m_MaxSpeed = value.m_MaxSpeed;
							
							return this;
						}
						
						public boolean isEqual(PrismaticJointSpecificationRec value)
						{
							if (m_LinkLength != value.getLinkLength())
							{
								return false;
							}
							if (m_TwistAngle != value.getTwistAngle())
							{
								return false;
							}
							if (m_JointAngle != value.getJointAngle())
							{
								return false;
							}
							if (m_MinValue != value.getMinValue())
							{
								return false;
							}
							if (m_MaxValue != value.getMaxValue())
							{
								return false;
							}
							if (m_MaxSpeed != value.getMaxSpeed())
							{
								return false;
							}
							
							return true;
						}
						
						public boolean notEquals(PrismaticJointSpecificationRec value)
						{
							return !this.isEqual(value);
						}
						
						public PrismaticJointSpecificationRec()
						{
							m_parent = null;
							m_LinkLength = 0;
							m_TwistAngle = 0;
							m_JointAngle = 0;
							m_MinValue = 0;
							m_MaxValue = 0;
							m_MaxSpeed = 0;
						}
						
						public PrismaticJointSpecificationRec(PrismaticJointSpecificationRec value)
						{
							/// Initiliaze the protected variables
							m_parent = null;
							m_LinkLength = 0;
							m_TwistAngle = 0;
							m_JointAngle = 0;
							m_MinValue = 0;
							m_MaxValue = 0;
							m_MaxSpeed = 0;
							
							/// Copy the values
							m_LinkLength = value.m_LinkLength;
							m_TwistAngle = value.m_TwistAngle;
							m_JointAngle = value.m_JointAngle;
							m_MinValue = value.m_MinValue;
							m_MaxValue = value.m_MaxValue;
							m_MaxSpeed = value.m_MaxSpeed;
						}
						
						public void finalize()
						{
						}
						
					}
				
				
					protected JointSpecificationList m_parent;
					protected short m_FieldValue;
					protected RevoluteJointSpecificationRec m_RevoluteJointSpecificationRec;
					protected PrismaticJointSpecificationRec m_PrismaticJointSpecificationRec;
				
					public void setParent(JointSpecificationList parent)
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
					
					public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications.RevoluteJointSpecificationRec getRevoluteJointSpecificationRec()
					{
						return m_RevoluteJointSpecificationRec;
					}
					
					public void setRevoluteJointSpecificationRec(RevoluteJointSpecificationRec value)
					{
						m_RevoluteJointSpecificationRec = value;
						setParentPresenceVector();
					}
					
					public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications.PrismaticJointSpecificationRec getPrismaticJointSpecificationRec()
					{
						return m_PrismaticJointSpecificationRec;
					}
					
					public void setPrismaticJointSpecificationRec(PrismaticJointSpecificationRec value)
					{
						m_PrismaticJointSpecificationRec = value;
						setParentPresenceVector();
					}
					
					public short getFieldValue()
					{
						return m_FieldValue;
					}
					
					public void setFieldValue(short fieldValue)
					{
						if(fieldValue > 1)
						{
							return;
						}
						
						m_FieldValue = fieldValue;
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
						
						switch(m_FieldValue)
						{
							case 0:
								size += m_RevoluteJointSpecificationRec.getSize();
								break;
							case 1:
								size += m_PrismaticJointSpecificationRec.getSize();
								break;
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
						bytes.put(pos, (byte) m_FieldValue);
						pos += JausUtils.getNumBytes("byte");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						
						switch(m_FieldValue)
						{
							case 0:
								m_RevoluteJointSpecificationRec.encode(bytes, pos);
								pos += m_RevoluteJointSpecificationRec.getSize();
								break;
							case 1:
								m_PrismaticJointSpecificationRec.encode(bytes, pos);
								pos += m_PrismaticJointSpecificationRec.getSize();
								break;
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
						m_FieldValue = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						
						switch(m_FieldValue)
						{
							case 0:
								m_RevoluteJointSpecificationRec.decode(bytes, pos);
								pos += m_RevoluteJointSpecificationRec.getSize();
								break;
							case 1:
								m_PrismaticJointSpecificationRec.decode(bytes, pos);
								pos += m_PrismaticJointSpecificationRec.getSize();
								break;
						}
					}
					
					public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications assign(JointSpecifications value)
					{
						m_FieldValue = value.m_FieldValue;
						m_RevoluteJointSpecificationRec = value.m_RevoluteJointSpecificationRec;
						m_RevoluteJointSpecificationRec.setParent(this);
						m_PrismaticJointSpecificationRec = value.m_PrismaticJointSpecificationRec;
						m_PrismaticJointSpecificationRec.setParent(this);
						
						return this;
					}
					
					public boolean isEqual(JointSpecifications value)
					{
						if (m_FieldValue != value.m_FieldValue)
						{
							return false;
						}
						if (!m_RevoluteJointSpecificationRec.isEqual(value.getRevoluteJointSpecificationRec()))
						{
							return false;
						}
						if (!m_PrismaticJointSpecificationRec.isEqual(value.getPrismaticJointSpecificationRec()))
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(JointSpecifications value)
					{
						return !this.isEqual(value);
					}
					
					public JointSpecifications()
					{
						m_parent = null;
						m_RevoluteJointSpecificationRec = new RevoluteJointSpecificationRec();
						m_RevoluteJointSpecificationRec.setParent(this);
						m_PrismaticJointSpecificationRec = new PrismaticJointSpecificationRec();
						m_PrismaticJointSpecificationRec.setParent(this);
					}
					
					public JointSpecifications(JointSpecifications value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_RevoluteJointSpecificationRec = new RevoluteJointSpecificationRec();
						m_RevoluteJointSpecificationRec.setParent(this);
						m_PrismaticJointSpecificationRec = new PrismaticJointSpecificationRec();
						m_PrismaticJointSpecificationRec.setParent(this);
						
						/// Copy the values
						m_FieldValue = value.m_FieldValue;
						m_RevoluteJointSpecificationRec = value.m_RevoluteJointSpecificationRec;
						m_RevoluteJointSpecificationRec.setParent(this);
						m_PrismaticJointSpecificationRec = value.m_PrismaticJointSpecificationRec;
						m_PrismaticJointSpecificationRec.setParent(this);
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected ReportManipulatorSpecification m_parent;
				protected ArrayList<JointSpecifications> m_JointSpecifications;
			
				public void setParent(ReportManipulatorSpecification parent)
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
				
				public long getNumberOfElements()
				{
					return (long) m_JointSpecifications.size();
				}
				
				public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList.JointSpecifications getElement(int index)
				{
					return m_JointSpecifications.get(index);
				}
				
				public void setElement(int index, JointSpecifications value)
				{
					if(m_JointSpecifications.size()-1 < index)
					{
						return;
					}
					
					m_JointSpecifications.get(index).assign(value);
					m_JointSpecifications.get(index).setParent(this);
					setParentPresenceVector();
				}
				
				public void addElement(JointSpecifications value)
				{
					m_JointSpecifications.add(value);
					m_JointSpecifications.get(m_JointSpecifications.size()-1).setParent(this);
					setParentPresenceVector();
				}
				
				public void deleteElement(int index)
				{
					if(m_JointSpecifications.size()-1 < index)
					{
						return;
					}
					
					m_JointSpecifications.remove(index);
				}
				
				public void  deleteLastElement()
				{
					m_JointSpecifications.remove(m_JointSpecifications.size() -1);
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
					for (int i = 0; i < m_JointSpecifications.size(); i++)
					{
						size += m_JointSpecifications.get(i).getSize();
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
					
					short size = (short) m_JointSpecifications.size();
					bytes.put(pos, (byte) size);
					pos += JausUtils.getNumBytes("byte");
					for (int i = 0; i < m_JointSpecifications.size(); i++)
					{
						m_JointSpecifications.get(i).encode(bytes, pos);
						pos += m_JointSpecifications.get(i).getSize();
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
					
					short size;
					size = (short) (bytes.get(pos) & 0xff);
					pos += JausUtils.getNumBytes("byte");
					m_JointSpecifications = new ArrayList<JointSpecifications>();
					for (int i = 0; i < size; i++)
					{
						m_JointSpecifications.add(new JointSpecifications());
						m_JointSpecifications.get(i).decode(bytes, pos);
						pos += m_JointSpecifications.get(i).getSize();
					}
				}
				
				public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList assign(JointSpecificationList value)
				{
					m_JointSpecifications.clear();
					
					for (int i = 0; i < value.m_JointSpecifications.size(); i++)
					{
						m_JointSpecifications.add(value.m_JointSpecifications.get(i));
						m_JointSpecifications.get(i).setParent(this);
					}
					
					return this;
				}
				
				public boolean isEqual(JointSpecificationList value)
				{
					for (int i = 0; i < m_JointSpecifications.size(); i++)
					{
						if (m_JointSpecifications.get(i) != value.m_JointSpecifications.get(i))
						{
							return false;
						}
					}
					
					return true;
				}
				
				public boolean notEquals(JointSpecificationList value)
				{
					return !this.isEqual(value);
				}
				
				public JointSpecificationList()
				{
					m_parent = null;
					m_JointSpecifications = new ArrayList<JointSpecifications>();
					for (int i = 0; i < m_JointSpecifications.size(); i++)
					{
						m_JointSpecifications.get(i).setParent(this);
					}
				}
				
				public JointSpecificationList(JointSpecificationList value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_JointSpecifications = new ArrayList<JointSpecifications>();
					for (int i = 0; i < m_JointSpecifications.size(); i++)
					{
						m_JointSpecifications.get(i).setParent(this);
					}
					
					/// Copy the values
					m_JointSpecifications.clear();
					
					for (int i = 0; i < value.m_JointSpecifications.size(); i++)
					{
						m_JointSpecifications.add(value.m_JointSpecifications.get(i));
						m_JointSpecifications.get(i).setParent(this);
					}
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ManipulatorCoordinateSystemRec m_ManipulatorCoordinateSystemRec;
			protected JointSpecificationList m_JointSpecificationList;
		
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
			
			public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.ManipulatorCoordinateSystemRec getManipulatorCoordinateSystemRec()
			{
				return m_ManipulatorCoordinateSystemRec;
			}
			
			public void setManipulatorCoordinateSystemRec(ManipulatorCoordinateSystemRec value)
			{
				m_ManipulatorCoordinateSystemRec = value;
				setParentPresenceVector();
			}
			
			public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification.JointSpecificationList getJointSpecificationList()
			{
				return m_JointSpecificationList;
			}
			
			public void setJointSpecificationList(JointSpecificationList value)
			{
				m_JointSpecificationList = value;
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
				
				size += m_ManipulatorCoordinateSystemRec.getSize();
				size += m_JointSpecificationList.getSize();
				
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
				
				m_ManipulatorCoordinateSystemRec.encode(bytes, pos);
				pos += m_ManipulatorCoordinateSystemRec.getSize();
				m_JointSpecificationList.encode(bytes, pos);
				pos += m_JointSpecificationList.getSize();
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
				
				m_ManipulatorCoordinateSystemRec.decode(bytes, pos);
				pos += m_ManipulatorCoordinateSystemRec.getSize();
				m_JointSpecificationList.decode(bytes, pos);
				pos += m_JointSpecificationList.getSize();
			}
			
			public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification assign(ReportManipulatorSpecification value)
			{
				m_ManipulatorCoordinateSystemRec = value.m_ManipulatorCoordinateSystemRec;
				m_ManipulatorCoordinateSystemRec.setParent(this);
				m_ManipulatorCoordinateSystemRec = value.m_ManipulatorCoordinateSystemRec;
				m_JointSpecificationList = value.m_JointSpecificationList;
				m_JointSpecificationList.setParent(this);
				m_JointSpecificationList = value.m_JointSpecificationList;
				
				return this;
			}
			
			public boolean isEqual(ReportManipulatorSpecification value)
			{
				if (!m_ManipulatorCoordinateSystemRec.isEqual(value.getManipulatorCoordinateSystemRec()))
				{
					return false;
				}
				
				if (!m_ManipulatorCoordinateSystemRec.isEqual(value.getManipulatorCoordinateSystemRec()))
				{
					return false;
				}
				if (!m_JointSpecificationList.isEqual(value.m_JointSpecificationList))
				{
					return false;
				}
				
				if (!m_JointSpecificationList.isEqual(value.getJointSpecificationList()))
				{
					return false;
				}
				
				return true;
			}
			
			public boolean notEquals(ReportManipulatorSpecification value)
			{
				return !this.isEqual(value);
			}
			
			public ReportManipulatorSpecification()
			{
				m_parent = null;
				m_ManipulatorCoordinateSystemRec = new ManipulatorCoordinateSystemRec();
				m_ManipulatorCoordinateSystemRec.setParent(this);
				m_JointSpecificationList = new JointSpecificationList();
				m_JointSpecificationList.setParent(this);
			}
			
			public ReportManipulatorSpecification(ReportManipulatorSpecification value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_ManipulatorCoordinateSystemRec = new ManipulatorCoordinateSystemRec();
				m_ManipulatorCoordinateSystemRec.setParent(this);
				m_JointSpecificationList = new JointSpecificationList();
				m_JointSpecificationList.setParent(this);
				
				/// Copy the values
				m_ManipulatorCoordinateSystemRec = value.m_ManipulatorCoordinateSystemRec;
				m_ManipulatorCoordinateSystemRec.setParent(this);
				m_ManipulatorCoordinateSystemRec = value.m_ManipulatorCoordinateSystemRec;
				m_JointSpecificationList = value.m_JointSpecificationList;
				m_JointSpecificationList.setParent(this);
				m_JointSpecificationList = value.m_JointSpecificationList;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ReportManipulatorSpecification m_ReportManipulatorSpecification;
	
		public ReportManipulatorSpecifications.Body.ReportManipulatorSpecification getReportManipulatorSpecification()
		{
			return m_ReportManipulatorSpecification;
		}
		
		public int setReportManipulatorSpecification(ReportManipulatorSpecification value)
		{
			m_ReportManipulatorSpecification = value;
			setParentPresenceVector();
			return 0;
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
			
			size += m_ReportManipulatorSpecification.getSize();
			
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
			
			m_ReportManipulatorSpecification.encode(bytes, pos);
			pos += m_ReportManipulatorSpecification.getSize();
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
			
			m_ReportManipulatorSpecification.decode(bytes, pos);
			pos += m_ReportManipulatorSpecification.getSize();
		}
		
		public ReportManipulatorSpecifications.Body assign(Body value)
		{
			m_ReportManipulatorSpecification = value.m_ReportManipulatorSpecification;
			m_ReportManipulatorSpecification.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ReportManipulatorSpecification.isEqual(value.getReportManipulatorSpecification()))
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
			m_ReportManipulatorSpecification = new ReportManipulatorSpecification();
			m_ReportManipulatorSpecification.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ReportManipulatorSpecification = new ReportManipulatorSpecification();
			m_ReportManipulatorSpecification.setParent(this);
			
			/// Copy the values
			m_ReportManipulatorSpecification = value.m_ReportManipulatorSpecification;
			m_ReportManipulatorSpecification.setParent(this);
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
	public ReportManipulatorSpecifications.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportManipulatorSpecifications.Body getBody()
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
	
	public ReportManipulatorSpecifications setAs(ReportManipulatorSpecifications value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportManipulatorSpecifications value)
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
	
	public boolean notEquals(ReportManipulatorSpecifications value)
	{
		return !isEqual(value);
	}
	
	public ReportManipulatorSpecifications()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportManipulatorSpecifications(ReportManipulatorSpecifications value)
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

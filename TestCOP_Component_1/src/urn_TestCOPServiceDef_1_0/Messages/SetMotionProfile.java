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

public class SetMotionProfile extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x0607;
	
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
			
			public SetMotionProfile.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x0607;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x0607;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public SetMotionProfile.AppHeader.HeaderRec getHeaderRec()
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
		
		public SetMotionProfile.AppHeader assign(AppHeader value)
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
		public static class  MotionProfileList
		{
			public static class  JointType
			{
				public static class  RevoluteMotionProfileRec
				{
				
					protected JointType m_parent;
					protected long m_JointMaxSpeed;
					protected long m_JointMaxAccelerationRate;
					protected long m_JointMaxDecelerationRate;
				
					public void setParent(JointType parent)
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
					
					public double getJointMaxSpeed()
					{
						double value;
						
						double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxSpeed * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxSpeed(double value)
					{
						if ((value >= 0) && (value <= 31.41592653589793))
						{
							double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxSpeed= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
						}
						return;
					}
					
					public double getJointMaxAccelerationRate()
					{
						double value;
						
						double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxAccelerationRate * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxAccelerationRate(double value)
					{
						if ((value >= 0) && (value <= 31.41592653589793))
						{
							double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxAccelerationRate= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
						}
						return;
					}
					
					public double getJointMaxDecelerationRate()
					{
						double value;
						
						double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxDecelerationRate * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxDecelerationRate(double value)
					{
						if ((value >= 0) && (value <= 31.41592653589793))
						{
							double scaleFactor = ( 31.41592653589793 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxDecelerationRate= (long)((value - bias) / scaleFactor);
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
						
						bytes.putInt(pos, (int) m_JointMaxSpeed);
						pos += JausUtils.getNumBytes("int");
						bytes.putInt(pos, (int) m_JointMaxAccelerationRate);
						pos += JausUtils.getNumBytes("int");
						bytes.putInt(pos, (int) m_JointMaxDecelerationRate);
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
						
						m_JointMaxSpeed = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						m_JointMaxAccelerationRate = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						m_JointMaxDecelerationRate = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					
					public SetMotionProfile.Body.MotionProfileList.JointType.RevoluteMotionProfileRec assign(RevoluteMotionProfileRec value)
					{
						m_JointMaxSpeed = value.m_JointMaxSpeed;
						m_JointMaxAccelerationRate = value.m_JointMaxAccelerationRate;
						m_JointMaxDecelerationRate = value.m_JointMaxDecelerationRate;
						
						return this;
					}
					
					public boolean isEqual(RevoluteMotionProfileRec value)
					{
						if (m_JointMaxSpeed != value.getJointMaxSpeed())
						{
							return false;
						}
						if (m_JointMaxAccelerationRate != value.getJointMaxAccelerationRate())
						{
							return false;
						}
						if (m_JointMaxDecelerationRate != value.getJointMaxDecelerationRate())
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(RevoluteMotionProfileRec value)
					{
						return !this.isEqual(value);
					}
					
					public RevoluteMotionProfileRec()
					{
						m_parent = null;
						m_JointMaxSpeed = 0;
						m_JointMaxAccelerationRate = 0;
						m_JointMaxDecelerationRate = 0;
					}
					
					public RevoluteMotionProfileRec(RevoluteMotionProfileRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_JointMaxSpeed = 0;
						m_JointMaxAccelerationRate = 0;
						m_JointMaxDecelerationRate = 0;
						
						/// Copy the values
						m_JointMaxSpeed = value.m_JointMaxSpeed;
						m_JointMaxAccelerationRate = value.m_JointMaxAccelerationRate;
						m_JointMaxDecelerationRate = value.m_JointMaxDecelerationRate;
					}
					
					public void finalize()
					{
					}
					
				}
				public static class  PrismaticMotionProfileRec
				{
				
					protected JointType m_parent;
					protected long m_JointMaxSpeed;
					protected long m_JointMaxAccelerationRate;
					protected long m_JointMaxDecelerationRate;
				
					public void setParent(JointType parent)
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
					
					public double getJointMaxSpeed()
					{
						double value;
						
						double scaleFactor = ( 5 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxSpeed * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxSpeed(double value)
					{
						if ((value >= 0) && (value <= 5))
						{
							double scaleFactor = ( 5 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxSpeed= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
						}
						return;
					}
					
					public double getJointMaxAccelerationRate()
					{
						double value;
						
						double scaleFactor = ( 20 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxAccelerationRate * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxAccelerationRate(double value)
					{
						if ((value >= 0) && (value <= 20))
						{
							double scaleFactor = ( 20 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxAccelerationRate= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
						}
						return;
					}
					
					public double getJointMaxDecelerationRate()
					{
						double value;
						
						double scaleFactor = ( 20 - 0 ) / 4.294967295E9;
						double bias = 0;
						
						value = m_JointMaxDecelerationRate * scaleFactor + bias;
						
						return value;
					}
					
					public void setJointMaxDecelerationRate(double value)
					{
						if ((value >= 0) && (value <= 20))
						{
							double scaleFactor = ( 20 - 0 ) / 4.294967295E9;
							double bias = 0;
							
							m_JointMaxDecelerationRate= (long)((value - bias) / scaleFactor);
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
						
						bytes.putInt(pos, (int) m_JointMaxSpeed);
						pos += JausUtils.getNumBytes("int");
						bytes.putInt(pos, (int) m_JointMaxAccelerationRate);
						pos += JausUtils.getNumBytes("int");
						bytes.putInt(pos, (int) m_JointMaxDecelerationRate);
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
						
						m_JointMaxSpeed = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						m_JointMaxAccelerationRate = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						m_JointMaxDecelerationRate = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
					}
					
					public SetMotionProfile.Body.MotionProfileList.JointType.PrismaticMotionProfileRec assign(PrismaticMotionProfileRec value)
					{
						m_JointMaxSpeed = value.m_JointMaxSpeed;
						m_JointMaxAccelerationRate = value.m_JointMaxAccelerationRate;
						m_JointMaxDecelerationRate = value.m_JointMaxDecelerationRate;
						
						return this;
					}
					
					public boolean isEqual(PrismaticMotionProfileRec value)
					{
						if (m_JointMaxSpeed != value.getJointMaxSpeed())
						{
							return false;
						}
						if (m_JointMaxAccelerationRate != value.getJointMaxAccelerationRate())
						{
							return false;
						}
						if (m_JointMaxDecelerationRate != value.getJointMaxDecelerationRate())
						{
							return false;
						}
						
						return true;
					}
					
					public boolean notEquals(PrismaticMotionProfileRec value)
					{
						return !this.isEqual(value);
					}
					
					public PrismaticMotionProfileRec()
					{
						m_parent = null;
						m_JointMaxSpeed = 0;
						m_JointMaxAccelerationRate = 0;
						m_JointMaxDecelerationRate = 0;
					}
					
					public PrismaticMotionProfileRec(PrismaticMotionProfileRec value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_JointMaxSpeed = 0;
						m_JointMaxAccelerationRate = 0;
						m_JointMaxDecelerationRate = 0;
						
						/// Copy the values
						m_JointMaxSpeed = value.m_JointMaxSpeed;
						m_JointMaxAccelerationRate = value.m_JointMaxAccelerationRate;
						m_JointMaxDecelerationRate = value.m_JointMaxDecelerationRate;
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected MotionProfileList m_parent;
				protected short m_FieldValue;
				protected RevoluteMotionProfileRec m_RevoluteMotionProfileRec;
				protected PrismaticMotionProfileRec m_PrismaticMotionProfileRec;
			
				public void setParent(MotionProfileList parent)
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
				
				public SetMotionProfile.Body.MotionProfileList.JointType.RevoluteMotionProfileRec getRevoluteMotionProfileRec()
				{
					return m_RevoluteMotionProfileRec;
				}
				
				public void setRevoluteMotionProfileRec(RevoluteMotionProfileRec value)
				{
					m_RevoluteMotionProfileRec = value;
					setParentPresenceVector();
				}
				
				public SetMotionProfile.Body.MotionProfileList.JointType.PrismaticMotionProfileRec getPrismaticMotionProfileRec()
				{
					return m_PrismaticMotionProfileRec;
				}
				
				public void setPrismaticMotionProfileRec(PrismaticMotionProfileRec value)
				{
					m_PrismaticMotionProfileRec = value;
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
							size += m_RevoluteMotionProfileRec.getSize();
							break;
						case 1:
							size += m_PrismaticMotionProfileRec.getSize();
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
							m_RevoluteMotionProfileRec.encode(bytes, pos);
							pos += m_RevoluteMotionProfileRec.getSize();
							break;
						case 1:
							m_PrismaticMotionProfileRec.encode(bytes, pos);
							pos += m_PrismaticMotionProfileRec.getSize();
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
							m_RevoluteMotionProfileRec.decode(bytes, pos);
							pos += m_RevoluteMotionProfileRec.getSize();
							break;
						case 1:
							m_PrismaticMotionProfileRec.decode(bytes, pos);
							pos += m_PrismaticMotionProfileRec.getSize();
							break;
					}
				}
				
				public SetMotionProfile.Body.MotionProfileList.JointType assign(JointType value)
				{
					m_FieldValue = value.m_FieldValue;
					m_RevoluteMotionProfileRec = value.m_RevoluteMotionProfileRec;
					m_RevoluteMotionProfileRec.setParent(this);
					m_PrismaticMotionProfileRec = value.m_PrismaticMotionProfileRec;
					m_PrismaticMotionProfileRec.setParent(this);
					
					return this;
				}
				
				public boolean isEqual(JointType value)
				{
					if (m_FieldValue != value.m_FieldValue)
					{
						return false;
					}
					if (!m_RevoluteMotionProfileRec.isEqual(value.getRevoluteMotionProfileRec()))
					{
						return false;
					}
					if (!m_PrismaticMotionProfileRec.isEqual(value.getPrismaticMotionProfileRec()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(JointType value)
				{
					return !this.isEqual(value);
				}
				
				public JointType()
				{
					m_parent = null;
					m_RevoluteMotionProfileRec = new RevoluteMotionProfileRec();
					m_RevoluteMotionProfileRec.setParent(this);
					m_PrismaticMotionProfileRec = new PrismaticMotionProfileRec();
					m_PrismaticMotionProfileRec.setParent(this);
				}
				
				public JointType(JointType value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_RevoluteMotionProfileRec = new RevoluteMotionProfileRec();
					m_RevoluteMotionProfileRec.setParent(this);
					m_PrismaticMotionProfileRec = new PrismaticMotionProfileRec();
					m_PrismaticMotionProfileRec.setParent(this);
					
					/// Copy the values
					m_FieldValue = value.m_FieldValue;
					m_RevoluteMotionProfileRec = value.m_RevoluteMotionProfileRec;
					m_RevoluteMotionProfileRec.setParent(this);
					m_PrismaticMotionProfileRec = value.m_PrismaticMotionProfileRec;
					m_PrismaticMotionProfileRec.setParent(this);
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<JointType> m_JointType;
		
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
			
			public long getNumberOfElements()
			{
				return (long) m_JointType.size();
			}
			
			public SetMotionProfile.Body.MotionProfileList.JointType getElement(int index)
			{
				return m_JointType.get(index);
			}
			
			public void setElement(int index, JointType value)
			{
				if(m_JointType.size()-1 < index)
				{
					return;
				}
				
				m_JointType.get(index).assign(value);
				m_JointType.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(JointType value)
			{
				m_JointType.add(value);
				m_JointType.get(m_JointType.size()-1).setParent(this);
				setParentPresenceVector();
			}
			
			public void deleteElement(int index)
			{
				if(m_JointType.size()-1 < index)
				{
					return;
				}
				
				m_JointType.remove(index);
			}
			
			public void  deleteLastElement()
			{
				m_JointType.remove(m_JointType.size() -1);
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
				for (int i = 0; i < m_JointType.size(); i++)
				{
					size += m_JointType.get(i).getSize();
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
				
				short size = (short) m_JointType.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_JointType.size(); i++)
				{
					m_JointType.get(i).encode(bytes, pos);
					pos += m_JointType.get(i).getSize();
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
				m_JointType = new ArrayList<JointType>();
				for (int i = 0; i < size; i++)
				{
					m_JointType.add(new JointType());
					m_JointType.get(i).decode(bytes, pos);
					pos += m_JointType.get(i).getSize();
				}
			}
			
			public SetMotionProfile.Body.MotionProfileList assign(MotionProfileList value)
			{
				m_JointType.clear();
				
				for (int i = 0; i < value.m_JointType.size(); i++)
				{
					m_JointType.add(value.m_JointType.get(i));
					m_JointType.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(MotionProfileList value)
			{
				for (int i = 0; i < m_JointType.size(); i++)
				{
					if (m_JointType.get(i) != value.m_JointType.get(i))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(MotionProfileList value)
			{
				return !this.isEqual(value);
			}
			
			public MotionProfileList()
			{
				m_parent = null;
				m_JointType = new ArrayList<JointType>();
				for (int i = 0; i < m_JointType.size(); i++)
				{
					m_JointType.get(i).setParent(this);
				}
			}
			
			public MotionProfileList(MotionProfileList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_JointType = new ArrayList<JointType>();
				for (int i = 0; i < m_JointType.size(); i++)
				{
					m_JointType.get(i).setParent(this);
				}
				
				/// Copy the values
				m_JointType.clear();
				
				for (int i = 0; i < value.m_JointType.size(); i++)
				{
					m_JointType.add(value.m_JointType.get(i));
					m_JointType.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected MotionProfileList m_MotionProfileList;
	
		public SetMotionProfile.Body.MotionProfileList getMotionProfileList()
		{
			return m_MotionProfileList;
		}
		
		public void setMotionProfileList(MotionProfileList value)
		{
			m_MotionProfileList = value;
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
			
			size += m_MotionProfileList.getSize();
			
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
			
			m_MotionProfileList.encode(bytes, pos);
			pos += m_MotionProfileList.getSize();
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
			
			m_MotionProfileList.decode(bytes, pos);
			pos += m_MotionProfileList.getSize();
		}
		
		public SetMotionProfile.Body assign(Body value)
		{
			m_MotionProfileList = value.m_MotionProfileList;
			m_MotionProfileList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_MotionProfileList.isEqual(value.m_MotionProfileList))
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
			m_MotionProfileList = new MotionProfileList();
			m_MotionProfileList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_MotionProfileList = new MotionProfileList();
			m_MotionProfileList.setParent(this);
			
			/// Copy the values
			m_MotionProfileList = value.m_MotionProfileList;
			m_MotionProfileList.setParent(this);
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
	public SetMotionProfile.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public SetMotionProfile.Body getBody()
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
	
	public SetMotionProfile setAs(SetMotionProfile value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(SetMotionProfile value)
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
	
	public boolean notEquals(SetMotionProfile value)
	{
		return !isEqual(value);
	}
	
	public SetMotionProfile()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = true;
	}
	
	public  SetMotionProfile(SetMotionProfile value)
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

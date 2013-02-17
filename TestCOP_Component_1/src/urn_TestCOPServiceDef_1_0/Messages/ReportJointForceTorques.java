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

public class ReportJointForceTorques extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4605;
	
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
			
			public ReportJointForceTorques.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4605;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4605;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportJointForceTorques.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportJointForceTorques.AppHeader assign(AppHeader value)
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
		public static class  ActuatorForceTorqueList
		{
			public static class  ActuatorForceTorqueRec
			{
				public static class  JointForceTorque
				{
				
					protected ActuatorForceTorqueRec m_parent;
					protected short m_Index;
					long m_NewtonMeterAsUnsignedIntegerAt0;
					long m_NewtonAsUnsignedIntegerAt1;
				
					public void setParent(ActuatorForceTorqueRec parent)
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
					
					public short getIndex()
					{
						return m_Index;
					}
					
					public int setIndex(short value)
					{
						if ((value == 1) || (value == 2))
						{
							m_Index = value;
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public double getNewtonMeterAsUnsignedIntegerAt0()
					{
						double value;
						
						double scaleFactor = ( 1000 - -1000 ) / 4.294967295E9;
						double bias = -1000;
						
						value = m_NewtonMeterAsUnsignedIntegerAt0 * scaleFactor + bias;
						
						return value;
					}
					
					public int setNewtonMeterAsUnsignedIntegerAt0(double value)
					{
						if ((value >= -1000) && (value <= 1000))
						{
							m_Index = 1;
							double scaleFactor = ( 1000 - -1000 ) / 4.294967295E9;
							double bias = -1000;
							
							m_NewtonMeterAsUnsignedIntegerAt0= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public double getNewtonAsUnsignedIntegerAt1()
					{
						double value;
						
						double scaleFactor = ( 500 - -500 ) / 4.294967295E9;
						double bias = -500;
						
						value = m_NewtonAsUnsignedIntegerAt1 * scaleFactor + bias;
						
						return value;
					}
					
					public int setNewtonAsUnsignedIntegerAt1(double value)
					{
						if ((value >= -500) && (value <= 500))
						{
							m_Index = 2;
							double scaleFactor = ( 500 - -500 ) / 4.294967295E9;
							double bias = -500;
							
							m_NewtonAsUnsignedIntegerAt1= (long)((value - bias) / scaleFactor);
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
						
						size += JausUtils.getNumBytes("byte");
						
						if (m_Index == 1)
						{
						size += JausUtils.getNumBytes("int");
						}
						
						if (m_Index == 2)
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
						
						bytes.put(pos, (byte) m_Index);
						pos += JausUtils.getNumBytes("byte");
						
						if (m_Index == 1)
						{
							try
							{
						bytes.putInt(pos, (int) m_NewtonMeterAsUnsignedIntegerAt0);
						pos += JausUtils.getNumBytes("int");
							}
							catch (Exception e)
						{
								logger.log(Level.SEVERE, null, e);
							}
						}
						
						if (m_Index == 2)
						{
							try
							{
						bytes.putInt(pos, (int) m_NewtonAsUnsignedIntegerAt1);
						pos += JausUtils.getNumBytes("int");
							}
							catch (Exception e)
						{
								logger.log(Level.SEVERE, null, e);
							}
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
						
						short m_IndexTemp;
						
						m_Index = (short) (bytes.get(pos) & 0xff);
						pos += JausUtils.getNumBytes("byte");
						
						if (m_Index == 1)
						{
							long tempValue;
						
						try
						{
						m_NewtonMeterAsUnsignedIntegerAt0 = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						}
						
						if (m_Index == 2)
						{
							long tempValue;
						
						try
						{
						m_NewtonAsUnsignedIntegerAt1 = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						}
					}
					
					public ReportJointForceTorques.Body.ActuatorForceTorqueList.ActuatorForceTorqueRec.JointForceTorque assign(JointForceTorque value)
					{
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_NewtonMeterAsUnsignedIntegerAt0 = (long)value.m_NewtonMeterAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_NewtonAsUnsignedIntegerAt1 = (long)value.m_NewtonAsUnsignedIntegerAt1;
						}
						
						return this;
					}
					
					public boolean isEqual(JointForceTorque value)
					{
						if (this.m_Index != value.m_Index)
						{
							return false;
						}
						
						if (m_Index == 1)
						{
							if (this.m_NewtonMeterAsUnsignedIntegerAt0 != value.m_NewtonMeterAsUnsignedIntegerAt0)
							{
								return false;
							}
						}
						
						if (m_Index == 2)
						{
							if (this.m_NewtonAsUnsignedIntegerAt1 != value.m_NewtonAsUnsignedIntegerAt1)
							{
								return false;
							}
						}
						
						return true;
					}
					
					public boolean notEquals(JointForceTorque value)
					{
						return !this.isEqual(value);
					}
					
					public JointForceTorque()
					{
						m_parent = null;
						m_Index = 1;
						m_NewtonMeterAsUnsignedIntegerAt0 = 0;
					}
					
					public JointForceTorque(JointForceTorque value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_Index = 1;
						m_NewtonMeterAsUnsignedIntegerAt0 = 0;
						
						/// Copy the values
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_NewtonMeterAsUnsignedIntegerAt0 = (long)value.m_NewtonMeterAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_NewtonAsUnsignedIntegerAt1 = (long)value.m_NewtonAsUnsignedIntegerAt1;
						}
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected ActuatorForceTorqueList m_parent;
				protected JointForceTorque m_JointForceTorque;
			
				public void setParent(ActuatorForceTorqueList parent)
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
				
				public ReportJointForceTorques.Body.ActuatorForceTorqueList.ActuatorForceTorqueRec.JointForceTorque getJointForceTorque()
				{
					return m_JointForceTorque;
				}
				
				public int setJointForceTorque(JointForceTorque value)
				{
					m_JointForceTorque = value;
					setParentPresenceVector();
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
					long size = 0;
					
					size += m_JointForceTorque.getSize();
					
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
					
					m_JointForceTorque.encode(bytes, pos);
					pos += m_JointForceTorque.getSize();
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
					
					m_JointForceTorque.decode(bytes, pos);
					pos += m_JointForceTorque.getSize();
				}
				
				public ReportJointForceTorques.Body.ActuatorForceTorqueList.ActuatorForceTorqueRec assign(ActuatorForceTorqueRec value)
				{
					m_JointForceTorque = value.m_JointForceTorque;
					
					return this;
				}
				
				public boolean isEqual(ActuatorForceTorqueRec value)
				{
					if (!m_JointForceTorque.isEqual(value.getJointForceTorque()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(ActuatorForceTorqueRec value)
				{
					return !this.isEqual(value);
				}
				
				public ActuatorForceTorqueRec()
				{
					m_parent = null;
					m_JointForceTorque = new JointForceTorque();
					m_JointForceTorque.setParent(this);
				}
				
				public ActuatorForceTorqueRec(ActuatorForceTorqueRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_JointForceTorque = new JointForceTorque();
					m_JointForceTorque.setParent(this);
					
					/// Copy the values
					m_JointForceTorque = value.m_JointForceTorque;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<ActuatorForceTorqueRec> m_ActuatorForceTorqueRec;
		
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
				return (long) m_ActuatorForceTorqueRec.size();
			}
			
			public ReportJointForceTorques.Body.ActuatorForceTorqueList.ActuatorForceTorqueRec getElement(int index)
			{
				return m_ActuatorForceTorqueRec.get(index);
			}
			
			public void setElement(int index, ActuatorForceTorqueRec value)
			{
				if(m_ActuatorForceTorqueRec.size()-1 < index)
				{
					return;
				}
				
				m_ActuatorForceTorqueRec.set(index, value);
				m_ActuatorForceTorqueRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(ActuatorForceTorqueRec value)
			{
				m_ActuatorForceTorqueRec.add(value);
				m_ActuatorForceTorqueRec.get(m_ActuatorForceTorqueRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_ActuatorForceTorqueRec.size()-1 < index)
				{
					return 1;
				}
				
				m_ActuatorForceTorqueRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_ActuatorForceTorqueRec.remove(m_ActuatorForceTorqueRec.size()-1);
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
				long size = 0;
				
				size += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_ActuatorForceTorqueRec.size(); i++)
				{
					size += m_ActuatorForceTorqueRec.get(i).getSize();
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
				
				short size = (short) m_ActuatorForceTorqueRec.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_ActuatorForceTorqueRec.size(); i++)
				{
					m_ActuatorForceTorqueRec.get(i).encode(bytes, pos);
					pos += m_ActuatorForceTorqueRec.get(i).getSize();
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
				m_ActuatorForceTorqueRec = new ArrayList<ActuatorForceTorqueRec>();
				for (int i = 0; i <  size; i++)
				{
					ActuatorForceTorqueRec item = new ActuatorForceTorqueRec();
					item.decode(bytes, pos);
					m_ActuatorForceTorqueRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportJointForceTorques.Body.ActuatorForceTorqueList assign(ActuatorForceTorqueList value)
			{
				m_ActuatorForceTorqueRec.clear();
				
				for (int i = 0; i < value.m_ActuatorForceTorqueRec.size(); i++)
				{
					m_ActuatorForceTorqueRec.add(value.m_ActuatorForceTorqueRec.get(i));
					m_ActuatorForceTorqueRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(ActuatorForceTorqueList value)
			{
				for (int i = 0; i < m_ActuatorForceTorqueRec.size(); i++)
				{
					if (!m_ActuatorForceTorqueRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(ActuatorForceTorqueList value)
			{
				return !this.isEqual(value);
			}
			
			public ActuatorForceTorqueList()
			{
				m_parent = null;
				m_ActuatorForceTorqueRec = new ArrayList<ActuatorForceTorqueRec>();
				for (int i = 0; i < m_ActuatorForceTorqueRec.size(); i++)
				{
					m_ActuatorForceTorqueRec.get(i).setParent(this);
				}
			}
			
			public ActuatorForceTorqueList(ActuatorForceTorqueList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_ActuatorForceTorqueRec = new ArrayList<ActuatorForceTorqueRec>();
				for (int i = 0; i < m_ActuatorForceTorqueRec.size(); i++)
				{
					m_ActuatorForceTorqueRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_ActuatorForceTorqueRec.clear();
				
				for (int i = 0; i < value.m_ActuatorForceTorqueRec.size(); i++)
				{
					m_ActuatorForceTorqueRec.add(value.m_ActuatorForceTorqueRec.get(i));
					m_ActuatorForceTorqueRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected ActuatorForceTorqueList m_ActuatorForceTorqueList;
	
		public ReportJointForceTorques.Body.ActuatorForceTorqueList getActuatorForceTorqueList()
		{
			return m_ActuatorForceTorqueList;
		}
		
		public void setActuatorForceTorqueList(ActuatorForceTorqueList value)
		{
			m_ActuatorForceTorqueList = value;
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
			
			size += m_ActuatorForceTorqueList.getSize();
			
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
			
			m_ActuatorForceTorqueList.encode(bytes, pos);
			pos += m_ActuatorForceTorqueList.getSize();
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
			
			m_ActuatorForceTorqueList.decode(bytes, pos);
			pos += m_ActuatorForceTorqueList.getSize();
		}
		
		public ReportJointForceTorques.Body assign(Body value)
		{
			m_ActuatorForceTorqueList = value.m_ActuatorForceTorqueList;
			m_ActuatorForceTorqueList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_ActuatorForceTorqueList.isEqual(value.m_ActuatorForceTorqueList))
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
			m_ActuatorForceTorqueList = new ActuatorForceTorqueList();
			m_ActuatorForceTorqueList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_ActuatorForceTorqueList = new ActuatorForceTorqueList();
			m_ActuatorForceTorqueList.setParent(this);
			
			/// Copy the values
			m_ActuatorForceTorqueList = value.m_ActuatorForceTorqueList;
			m_ActuatorForceTorqueList.setParent(this);
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
	public ReportJointForceTorques.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportJointForceTorques.Body getBody()
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
	
	public ReportJointForceTorques setAs(ReportJointForceTorques value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportJointForceTorques value)
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
	
	public boolean notEquals(ReportJointForceTorques value)
	{
		return !isEqual(value);
	}
	
	public ReportJointForceTorques()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportJointForceTorques(ReportJointForceTorques value)
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

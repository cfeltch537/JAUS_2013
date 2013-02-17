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

public class ReportJointVelocities extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4603;
	
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
			
			public ReportJointVelocities.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4603;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4603;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportJointVelocities.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportJointVelocities.AppHeader assign(AppHeader value)
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
		public static class  JointVelocityList
		{
			public static class  JointVelocityRec
			{
				public static class  JointVelocity
				{
				
					protected JointVelocityRec m_parent;
					protected short m_Index;
					long m_RadianPerSecondAsUnsignedIntegerAt0;
					long m_MeterPerSecondAsUnsignedIntegerAt1;
				
					public void setParent(JointVelocityRec parent)
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
					
					public double getRadianPerSecondAsUnsignedIntegerAt0()
					{
						double value;
						
						double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
						double bias = -31.41592653589793;
						
						value = m_RadianPerSecondAsUnsignedIntegerAt0 * scaleFactor + bias;
						
						return value;
					}
					
					public int setRadianPerSecondAsUnsignedIntegerAt0(double value)
					{
						if ((value >= -31.41592653589793) && (value <= 31.41592653589793))
						{
							m_Index = 1;
							double scaleFactor = ( 31.41592653589793 - -31.41592653589793 ) / 4.294967295E9;
							double bias = -31.41592653589793;
							
							m_RadianPerSecondAsUnsignedIntegerAt0= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public double getMeterPerSecondAsUnsignedIntegerAt1()
					{
						double value;
						
						double scaleFactor = ( 5 - -5 ) / 4.294967295E9;
						double bias = -5;
						
						value = m_MeterPerSecondAsUnsignedIntegerAt1 * scaleFactor + bias;
						
						return value;
					}
					
					public int setMeterPerSecondAsUnsignedIntegerAt1(double value)
					{
						if ((value >= -5) && (value <= 5))
						{
							m_Index = 2;
							double scaleFactor = ( 5 - -5 ) / 4.294967295E9;
							double bias = -5;
							
							m_MeterPerSecondAsUnsignedIntegerAt1= (long)((value - bias) / scaleFactor);
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
						bytes.putInt(pos, (int) m_RadianPerSecondAsUnsignedIntegerAt0);
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
						bytes.putInt(pos, (int) m_MeterPerSecondAsUnsignedIntegerAt1);
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
						m_RadianPerSecondAsUnsignedIntegerAt0 = bytes.getInt(pos) & 0xffffffffL;
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
						m_MeterPerSecondAsUnsignedIntegerAt1 = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						}
					}
					
					public ReportJointVelocities.Body.JointVelocityList.JointVelocityRec.JointVelocity assign(JointVelocity value)
					{
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_RadianPerSecondAsUnsignedIntegerAt0 = (long)value.m_RadianPerSecondAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_MeterPerSecondAsUnsignedIntegerAt1 = (long)value.m_MeterPerSecondAsUnsignedIntegerAt1;
						}
						
						return this;
					}
					
					public boolean isEqual(JointVelocity value)
					{
						if (this.m_Index != value.m_Index)
						{
							return false;
						}
						
						if (m_Index == 1)
						{
							if (this.m_RadianPerSecondAsUnsignedIntegerAt0 != value.m_RadianPerSecondAsUnsignedIntegerAt0)
							{
								return false;
							}
						}
						
						if (m_Index == 2)
						{
							if (this.m_MeterPerSecondAsUnsignedIntegerAt1 != value.m_MeterPerSecondAsUnsignedIntegerAt1)
							{
								return false;
							}
						}
						
						return true;
					}
					
					public boolean notEquals(JointVelocity value)
					{
						return !this.isEqual(value);
					}
					
					public JointVelocity()
					{
						m_parent = null;
						m_Index = 1;
						m_RadianPerSecondAsUnsignedIntegerAt0 = 0;
					}
					
					public JointVelocity(JointVelocity value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_Index = 1;
						m_RadianPerSecondAsUnsignedIntegerAt0 = 0;
						
						/// Copy the values
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_RadianPerSecondAsUnsignedIntegerAt0 = (long)value.m_RadianPerSecondAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_MeterPerSecondAsUnsignedIntegerAt1 = (long)value.m_MeterPerSecondAsUnsignedIntegerAt1;
						}
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected JointVelocityList m_parent;
				protected JointVelocity m_JointVelocity;
			
				public void setParent(JointVelocityList parent)
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
				
				public ReportJointVelocities.Body.JointVelocityList.JointVelocityRec.JointVelocity getJointVelocity()
				{
					return m_JointVelocity;
				}
				
				public int setJointVelocity(JointVelocity value)
				{
					m_JointVelocity = value;
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
					
					size += m_JointVelocity.getSize();
					
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
					
					m_JointVelocity.encode(bytes, pos);
					pos += m_JointVelocity.getSize();
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
					
					m_JointVelocity.decode(bytes, pos);
					pos += m_JointVelocity.getSize();
				}
				
				public ReportJointVelocities.Body.JointVelocityList.JointVelocityRec assign(JointVelocityRec value)
				{
					m_JointVelocity = value.m_JointVelocity;
					
					return this;
				}
				
				public boolean isEqual(JointVelocityRec value)
				{
					if (!m_JointVelocity.isEqual(value.getJointVelocity()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(JointVelocityRec value)
				{
					return !this.isEqual(value);
				}
				
				public JointVelocityRec()
				{
					m_parent = null;
					m_JointVelocity = new JointVelocity();
					m_JointVelocity.setParent(this);
				}
				
				public JointVelocityRec(JointVelocityRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_JointVelocity = new JointVelocity();
					m_JointVelocity.setParent(this);
					
					/// Copy the values
					m_JointVelocity = value.m_JointVelocity;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<JointVelocityRec> m_JointVelocityRec;
		
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
				return (long) m_JointVelocityRec.size();
			}
			
			public ReportJointVelocities.Body.JointVelocityList.JointVelocityRec getElement(int index)
			{
				return m_JointVelocityRec.get(index);
			}
			
			public void setElement(int index, JointVelocityRec value)
			{
				if(m_JointVelocityRec.size()-1 < index)
				{
					return;
				}
				
				m_JointVelocityRec.set(index, value);
				m_JointVelocityRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(JointVelocityRec value)
			{
				m_JointVelocityRec.add(value);
				m_JointVelocityRec.get(m_JointVelocityRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_JointVelocityRec.size()-1 < index)
				{
					return 1;
				}
				
				m_JointVelocityRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_JointVelocityRec.remove(m_JointVelocityRec.size()-1);
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
				for (int i = 0; i < m_JointVelocityRec.size(); i++)
				{
					size += m_JointVelocityRec.get(i).getSize();
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
				
				short size = (short) m_JointVelocityRec.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_JointVelocityRec.size(); i++)
				{
					m_JointVelocityRec.get(i).encode(bytes, pos);
					pos += m_JointVelocityRec.get(i).getSize();
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
				m_JointVelocityRec = new ArrayList<JointVelocityRec>();
				for (int i = 0; i <  size; i++)
				{
					JointVelocityRec item = new JointVelocityRec();
					item.decode(bytes, pos);
					m_JointVelocityRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportJointVelocities.Body.JointVelocityList assign(JointVelocityList value)
			{
				m_JointVelocityRec.clear();
				
				for (int i = 0; i < value.m_JointVelocityRec.size(); i++)
				{
					m_JointVelocityRec.add(value.m_JointVelocityRec.get(i));
					m_JointVelocityRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(JointVelocityList value)
			{
				for (int i = 0; i < m_JointVelocityRec.size(); i++)
				{
					if (!m_JointVelocityRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(JointVelocityList value)
			{
				return !this.isEqual(value);
			}
			
			public JointVelocityList()
			{
				m_parent = null;
				m_JointVelocityRec = new ArrayList<JointVelocityRec>();
				for (int i = 0; i < m_JointVelocityRec.size(); i++)
				{
					m_JointVelocityRec.get(i).setParent(this);
				}
			}
			
			public JointVelocityList(JointVelocityList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_JointVelocityRec = new ArrayList<JointVelocityRec>();
				for (int i = 0; i < m_JointVelocityRec.size(); i++)
				{
					m_JointVelocityRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_JointVelocityRec.clear();
				
				for (int i = 0; i < value.m_JointVelocityRec.size(); i++)
				{
					m_JointVelocityRec.add(value.m_JointVelocityRec.get(i));
					m_JointVelocityRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected JointVelocityList m_JointVelocityList;
	
		public ReportJointVelocities.Body.JointVelocityList getJointVelocityList()
		{
			return m_JointVelocityList;
		}
		
		public void setJointVelocityList(JointVelocityList value)
		{
			m_JointVelocityList = value;
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
			
			size += m_JointVelocityList.getSize();
			
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
			
			m_JointVelocityList.encode(bytes, pos);
			pos += m_JointVelocityList.getSize();
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
			
			m_JointVelocityList.decode(bytes, pos);
			pos += m_JointVelocityList.getSize();
		}
		
		public ReportJointVelocities.Body assign(Body value)
		{
			m_JointVelocityList = value.m_JointVelocityList;
			m_JointVelocityList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_JointVelocityList.isEqual(value.m_JointVelocityList))
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
			m_JointVelocityList = new JointVelocityList();
			m_JointVelocityList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_JointVelocityList = new JointVelocityList();
			m_JointVelocityList.setParent(this);
			
			/// Copy the values
			m_JointVelocityList = value.m_JointVelocityList;
			m_JointVelocityList.setParent(this);
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
	public ReportJointVelocities.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportJointVelocities.Body getBody()
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
	
	public ReportJointVelocities setAs(ReportJointVelocities value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportJointVelocities value)
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
	
	public boolean notEquals(ReportJointVelocities value)
	{
		return !isEqual(value);
	}
	
	public ReportJointVelocities()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportJointVelocities(ReportJointVelocities value)
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

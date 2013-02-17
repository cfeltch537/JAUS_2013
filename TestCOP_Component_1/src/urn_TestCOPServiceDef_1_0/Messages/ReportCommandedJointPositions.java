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

public class ReportCommandedJointPositions extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4608;
	
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
			
			public ReportCommandedJointPositions.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4608;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4608;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportCommandedJointPositions.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportCommandedJointPositions.AppHeader assign(AppHeader value)
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
		public static class  JointPositionList
		{
			public static class  JointPositionRec
			{
				public static class  JointPosition
				{
				
					protected JointPositionRec m_parent;
					protected short m_Index;
					long m_RadianAsUnsignedIntegerAt0;
					long m_MeterAsUnsignedIntegerAt1;
				
					public void setParent(JointPositionRec parent)
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
					
					public double getRadianAsUnsignedIntegerAt0()
					{
						double value;
						
						double scaleFactor = ( 25.132741228718345 - -25.132741228718345 ) / 4.294967295E9;
						double bias = -25.132741228718345;
						
						value = m_RadianAsUnsignedIntegerAt0 * scaleFactor + bias;
						
						return value;
					}
					
					public int setRadianAsUnsignedIntegerAt0(double value)
					{
						if ((value >= -25.132741228718345) && (value <= 25.132741228718345))
						{
							m_Index = 1;
							double scaleFactor = ( 25.132741228718345 - -25.132741228718345 ) / 4.294967295E9;
							double bias = -25.132741228718345;
							
							m_RadianAsUnsignedIntegerAt0= (long)((value - bias) / scaleFactor);
							setParentPresenceVector();
							return 0;
						}
						return 1;
					}
					
					public double getMeterAsUnsignedIntegerAt1()
					{
						double value;
						
						double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
						double bias = -10;
						
						value = m_MeterAsUnsignedIntegerAt1 * scaleFactor + bias;
						
						return value;
					}
					
					public int setMeterAsUnsignedIntegerAt1(double value)
					{
						if ((value >= -10) && (value <= 10))
						{
							m_Index = 2;
							double scaleFactor = ( 10 - -10 ) / 4.294967295E9;
							double bias = -10;
							
							m_MeterAsUnsignedIntegerAt1= (long)((value - bias) / scaleFactor);
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
						bytes.putInt(pos, (int) m_RadianAsUnsignedIntegerAt0);
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
						bytes.putInt(pos, (int) m_MeterAsUnsignedIntegerAt1);
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
						m_RadianAsUnsignedIntegerAt0 = bytes.getInt(pos) & 0xffffffffL;
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
						m_MeterAsUnsignedIntegerAt1 = bytes.getInt(pos) & 0xffffffffL;
						pos += JausUtils.getNumBytes("int");
						}
						catch (Exception e)
						{
							logger.log(Level.SEVERE, null, e);
						}
						}
					}
					
					public ReportCommandedJointPositions.Body.JointPositionList.JointPositionRec.JointPosition assign(JointPosition value)
					{
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_RadianAsUnsignedIntegerAt0 = (long)value.m_RadianAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_MeterAsUnsignedIntegerAt1 = (long)value.m_MeterAsUnsignedIntegerAt1;
						}
						
						return this;
					}
					
					public boolean isEqual(JointPosition value)
					{
						if (this.m_Index != value.m_Index)
						{
							return false;
						}
						
						if (m_Index == 1)
						{
							if (this.m_RadianAsUnsignedIntegerAt0 != value.m_RadianAsUnsignedIntegerAt0)
							{
								return false;
							}
						}
						
						if (m_Index == 2)
						{
							if (this.m_MeterAsUnsignedIntegerAt1 != value.m_MeterAsUnsignedIntegerAt1)
							{
								return false;
							}
						}
						
						return true;
					}
					
					public boolean notEquals(JointPosition value)
					{
						return !this.isEqual(value);
					}
					
					public JointPosition()
					{
						m_parent = null;
						m_Index = 1;
						m_RadianAsUnsignedIntegerAt0 = 0;
					}
					
					public JointPosition(JointPosition value)
					{
						/// Initiliaze the protected variables
						m_parent = null;
						m_Index = 1;
						m_RadianAsUnsignedIntegerAt0 = 0;
						
						/// Copy the values
						this.m_Index= value.m_Index;
						
						if (m_Index == 1)
						{
							this.m_RadianAsUnsignedIntegerAt0 = (long)value.m_RadianAsUnsignedIntegerAt0;
						}
						
						if (m_Index == 2)
						{
							this.m_MeterAsUnsignedIntegerAt1 = (long)value.m_MeterAsUnsignedIntegerAt1;
						}
					}
					
					public void finalize()
					{
					}
					
				}
			
			
				protected JointPositionList m_parent;
				protected JointPosition m_JointPosition;
			
				public void setParent(JointPositionList parent)
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
				
				public ReportCommandedJointPositions.Body.JointPositionList.JointPositionRec.JointPosition getJointPosition()
				{
					return m_JointPosition;
				}
				
				public int setJointPosition(JointPosition value)
				{
					m_JointPosition = value;
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
					
					size += m_JointPosition.getSize();
					
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
					
					m_JointPosition.encode(bytes, pos);
					pos += m_JointPosition.getSize();
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
					
					m_JointPosition.decode(bytes, pos);
					pos += m_JointPosition.getSize();
				}
				
				public ReportCommandedJointPositions.Body.JointPositionList.JointPositionRec assign(JointPositionRec value)
				{
					m_JointPosition = value.m_JointPosition;
					
					return this;
				}
				
				public boolean isEqual(JointPositionRec value)
				{
					if (!m_JointPosition.isEqual(value.getJointPosition()))
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(JointPositionRec value)
				{
					return !this.isEqual(value);
				}
				
				public JointPositionRec()
				{
					m_parent = null;
					m_JointPosition = new JointPosition();
					m_JointPosition.setParent(this);
				}
				
				public JointPositionRec(JointPositionRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_JointPosition = new JointPosition();
					m_JointPosition.setParent(this);
					
					/// Copy the values
					m_JointPosition = value.m_JointPosition;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<JointPositionRec> m_JointPositionRec;
		
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
				return (long) m_JointPositionRec.size();
			}
			
			public ReportCommandedJointPositions.Body.JointPositionList.JointPositionRec getElement(int index)
			{
				return m_JointPositionRec.get(index);
			}
			
			public void setElement(int index, JointPositionRec value)
			{
				if(m_JointPositionRec.size()-1 < index)
				{
					return;
				}
				
				m_JointPositionRec.set(index, value);
				m_JointPositionRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(JointPositionRec value)
			{
				m_JointPositionRec.add(value);
				m_JointPositionRec.get(m_JointPositionRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_JointPositionRec.size()-1 < index)
				{
					return 1;
				}
				
				m_JointPositionRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_JointPositionRec.remove(m_JointPositionRec.size()-1);
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
				for (int i = 0; i < m_JointPositionRec.size(); i++)
				{
					size += m_JointPositionRec.get(i).getSize();
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
				
				short size = (short) m_JointPositionRec.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_JointPositionRec.size(); i++)
				{
					m_JointPositionRec.get(i).encode(bytes, pos);
					pos += m_JointPositionRec.get(i).getSize();
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
				m_JointPositionRec = new ArrayList<JointPositionRec>();
				for (int i = 0; i <  size; i++)
				{
					JointPositionRec item = new JointPositionRec();
					item.decode(bytes, pos);
					m_JointPositionRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportCommandedJointPositions.Body.JointPositionList assign(JointPositionList value)
			{
				m_JointPositionRec.clear();
				
				for (int i = 0; i < value.m_JointPositionRec.size(); i++)
				{
					m_JointPositionRec.add(value.m_JointPositionRec.get(i));
					m_JointPositionRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(JointPositionList value)
			{
				for (int i = 0; i < m_JointPositionRec.size(); i++)
				{
					if (!m_JointPositionRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(JointPositionList value)
			{
				return !this.isEqual(value);
			}
			
			public JointPositionList()
			{
				m_parent = null;
				m_JointPositionRec = new ArrayList<JointPositionRec>();
				for (int i = 0; i < m_JointPositionRec.size(); i++)
				{
					m_JointPositionRec.get(i).setParent(this);
				}
			}
			
			public JointPositionList(JointPositionList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_JointPositionRec = new ArrayList<JointPositionRec>();
				for (int i = 0; i < m_JointPositionRec.size(); i++)
				{
					m_JointPositionRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_JointPositionRec.clear();
				
				for (int i = 0; i < value.m_JointPositionRec.size(); i++)
				{
					m_JointPositionRec.add(value.m_JointPositionRec.get(i));
					m_JointPositionRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected JointPositionList m_JointPositionList;
	
		public ReportCommandedJointPositions.Body.JointPositionList getJointPositionList()
		{
			return m_JointPositionList;
		}
		
		public void setJointPositionList(JointPositionList value)
		{
			m_JointPositionList = value;
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
			
			size += m_JointPositionList.getSize();
			
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
			
			m_JointPositionList.encode(bytes, pos);
			pos += m_JointPositionList.getSize();
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
			
			m_JointPositionList.decode(bytes, pos);
			pos += m_JointPositionList.getSize();
		}
		
		public ReportCommandedJointPositions.Body assign(Body value)
		{
			m_JointPositionList = value.m_JointPositionList;
			m_JointPositionList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_JointPositionList.isEqual(value.m_JointPositionList))
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
			m_JointPositionList = new JointPositionList();
			m_JointPositionList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_JointPositionList = new JointPositionList();
			m_JointPositionList.setParent(this);
			
			/// Copy the values
			m_JointPositionList = value.m_JointPositionList;
			m_JointPositionList.setParent(this);
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
	public ReportCommandedJointPositions.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportCommandedJointPositions.Body getBody()
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
	
	public ReportCommandedJointPositions setAs(ReportCommandedJointPositions value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportCommandedJointPositions value)
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
	
	public boolean notEquals(ReportCommandedJointPositions value)
	{
		return !isEqual(value);
	}
	
	public ReportCommandedJointPositions()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportCommandedJointPositions(ReportCommandedJointPositions value)
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

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

public class ReportJointEfforts extends Message
{
	protected static Logger logger = Logger.getLogger("framework.logger");
	public static int ID = 0x4601;
	
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
			
			public ReportJointEfforts.AppHeader.HeaderRec assign(HeaderRec value)
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
				m_MessageID = 0x4601;
			}
			
			public HeaderRec(HeaderRec value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_MessageID = 0x4601;
				
				/// Copy the values
				m_MessageID = value.m_MessageID;
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected HeaderRec m_HeaderRec;
	
		public ReportJointEfforts.AppHeader.HeaderRec getHeaderRec()
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
		
		public ReportJointEfforts.AppHeader assign(AppHeader value)
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
		public static class  JointEffortList
		{
			public static class  JointEffortRec
			{
			
				protected JointEffortList m_parent;
				protected int m_JointEffort;
			
				public void setParent(JointEffortList parent)
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
				
				public double getJointEffort()
				{
					double value;
					
					double scaleFactor = ( 100 - -100 ) / 65535.0;
					double bias = -100;
					
					value = m_JointEffort * scaleFactor + bias;
					
					return value;
				}
				
				public void setJointEffort(double value)
				{
					if ((value >= -100) && (value <= 100))
					{
						double scaleFactor = ( 100 - -100 ) / 65535.0;
						double bias = -100;
						
						m_JointEffort= (int)((value - bias) / scaleFactor);
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
					
					bytes.putShort(pos, (short) m_JointEffort);
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
					
					m_JointEffort = bytes.getShort(pos) & 0xffff;
					pos += JausUtils.getNumBytes("short");
				}
				
				public ReportJointEfforts.Body.JointEffortList.JointEffortRec assign(JointEffortRec value)
				{
					m_JointEffort = value.m_JointEffort;
					
					return this;
				}
				
				public boolean isEqual(JointEffortRec value)
				{
					if (m_JointEffort != value.getJointEffort())
					{
						return false;
					}
					
					return true;
				}
				
				public boolean notEquals(JointEffortRec value)
				{
					return !this.isEqual(value);
				}
				
				public JointEffortRec()
				{
					m_parent = null;
					m_JointEffort = 0;
				}
				
				public JointEffortRec(JointEffortRec value)
				{
					/// Initiliaze the protected variables
					m_parent = null;
					m_JointEffort = 0;
					
					/// Copy the values
					m_JointEffort = value.m_JointEffort;
				}
				
				public void finalize()
				{
				}
				
			}
		
		
			protected Body m_parent;
			protected ArrayList<JointEffortRec> m_JointEffortRec;
		
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
				return (long) m_JointEffortRec.size();
			}
			
			public ReportJointEfforts.Body.JointEffortList.JointEffortRec getElement(int index)
			{
				return m_JointEffortRec.get(index);
			}
			
			public void setElement(int index, JointEffortRec value)
			{
				if(m_JointEffortRec.size()-1 < index)
				{
					return;
				}
				
				m_JointEffortRec.set(index, value);
				m_JointEffortRec.get(index).setParent(this);
				setParentPresenceVector();
			}
			
			public void addElement(JointEffortRec value)
			{
				m_JointEffortRec.add(value);
				m_JointEffortRec.get(m_JointEffortRec.size() -1 ).setParent(this);
				setParentPresenceVector();
			}
			
			public int deleteElement(int index)
			{
				if(m_JointEffortRec.size()-1 < index)
				{
					return 1;
				}
				
				m_JointEffortRec.remove(index);
				return 0;
			}
			
			public int deleteLastElement()
			{
				m_JointEffortRec.remove(m_JointEffortRec.size()-1);
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
				for (int i = 0; i < m_JointEffortRec.size(); i++)
				{
					size += m_JointEffortRec.get(i).getSize();
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
				
				short size = (short) m_JointEffortRec.size();
				bytes.put(pos, (byte) size);
				pos += JausUtils.getNumBytes("byte");
				for (int i = 0; i < m_JointEffortRec.size(); i++)
				{
					m_JointEffortRec.get(i).encode(bytes, pos);
					pos += m_JointEffortRec.get(i).getSize();
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
				m_JointEffortRec = new ArrayList<JointEffortRec>();
				for (int i = 0; i <  size; i++)
				{
					JointEffortRec item = new JointEffortRec();
					item.decode(bytes, pos);
					m_JointEffortRec.add(item);
					pos += item.getSize();
				}
			}
			
			public ReportJointEfforts.Body.JointEffortList assign(JointEffortList value)
			{
				m_JointEffortRec.clear();
				
				for (int i = 0; i < value.m_JointEffortRec.size(); i++)
				{
					m_JointEffortRec.add(value.m_JointEffortRec.get(i));
					m_JointEffortRec.get(i).setParent(this);
				}
				
				return this;
			}
			
			public boolean isEqual(JointEffortList value)
			{
				for (int i = 0; i < m_JointEffortRec.size(); i++)
				{
					if (!m_JointEffortRec.get(i).isEqual(value.getElement(i)))
					{
						return false;
					}
				}
				
				return true;
			}
			
			public boolean notEquals(JointEffortList value)
			{
				return !this.isEqual(value);
			}
			
			public JointEffortList()
			{
				m_parent = null;
				m_JointEffortRec = new ArrayList<JointEffortRec>();
				for (int i = 0; i < m_JointEffortRec.size(); i++)
				{
					m_JointEffortRec.get(i).setParent(this);
				}
			}
			
			public JointEffortList(JointEffortList value)
			{
				/// Initiliaze the protected variables
				m_parent = null;
				m_JointEffortRec = new ArrayList<JointEffortRec>();
				for (int i = 0; i < m_JointEffortRec.size(); i++)
				{
					m_JointEffortRec.get(i).setParent(this);
				}
				
				/// Copy the values
				m_JointEffortRec.clear();
				
				for (int i = 0; i < value.m_JointEffortRec.size(); i++)
				{
					m_JointEffortRec.add(value.m_JointEffortRec.get(i));
					m_JointEffortRec.get(i).setParent(this);
				}
			}
			
			public void finalize()
			{
			}
			
		}
	
	
		protected JointEffortList m_JointEffortList;
	
		public ReportJointEfforts.Body.JointEffortList getJointEffortList()
		{
			return m_JointEffortList;
		}
		
		public void setJointEffortList(JointEffortList value)
		{
			m_JointEffortList = value;
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
			
			size += m_JointEffortList.getSize();
			
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
			
			m_JointEffortList.encode(bytes, pos);
			pos += m_JointEffortList.getSize();
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
			
			m_JointEffortList.decode(bytes, pos);
			pos += m_JointEffortList.getSize();
		}
		
		public ReportJointEfforts.Body assign(Body value)
		{
			m_JointEffortList = value.m_JointEffortList;
			m_JointEffortList.setParent(this);
			/// This code is currently not supported
			
			return this;
		}
		
		public boolean isEqual(Body value)
		{
			if (!m_JointEffortList.isEqual(value.m_JointEffortList))
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
			m_JointEffortList = new JointEffortList();
			m_JointEffortList.setParent(this);
		}
		
		public Body(Body value)
		{
			/// Initiliaze the protected variables
			m_JointEffortList = new JointEffortList();
			m_JointEffortList.setParent(this);
			
			/// Copy the values
			m_JointEffortList = value.m_JointEffortList;
			m_JointEffortList.setParent(this);
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
	public ReportJointEfforts.AppHeader getAppHeader()
	{
		return m_AppHeader;
	}
	
	public void setAppHeader(AppHeader value)
	{
		m_AppHeader = value;
	}
	
	public ReportJointEfforts.Body getBody()
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
	
	public ReportJointEfforts setAs(ReportJointEfforts value)
	{
		m_AppHeader = value.m_AppHeader;
		m_Body = value.m_Body;
		
		return this;
	}
	
	public boolean isEqual(ReportJointEfforts value)
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
	
	public boolean notEquals(ReportJointEfforts value)
	{
		return !isEqual(value);
	}
	
	public ReportJointEfforts()
	{
		m_AppHeader = new AppHeader();
		m_Body = new Body();
		m_IsCommand = false;
	}
	
	public  ReportJointEfforts(ReportJointEfforts value)
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
